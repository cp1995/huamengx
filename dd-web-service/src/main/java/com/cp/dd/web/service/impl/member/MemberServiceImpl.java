package com.cp.dd.web.service.impl.member;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.cp.dd.common.constant.CommonConstant;
import com.cp.dd.common.constant.Constants;
import com.cp.dd.common.entity.member.Area;
import com.cp.dd.common.entity.sys.SysMsg;
import com.cp.dd.common.exception.ApiException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.dd.common.constant.member.*;
import com.cp.dd.common.entity.member.Member;
import com.cp.dd.common.mapper.member.AreaMapper;
import com.cp.dd.common.mapper.member.MemberMapper;
import com.cp.dd.common.mapper.sys.SysMsgMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.util.ExcelUtil;
import com.cp.dd.common.util.PatternUtils;
import com.cp.dd.common.util.security.AesEncryptUtil;
import com.cp.dd.common.util.security.DigestUtil;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.util.sys.SysSmsCaptchaUtil;
import com.cp.dd.common.util.sys.TokenUtil;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.web.form.member.MemberForm;
import com.cp.dd.web.form.member.MemberLoginForm;
import com.cp.dd.web.service.member.IMemberService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


/**
 * <p>
 * 会员信息 服务实现类
 * </p>
 *
 * @author chengp
 * @date 2019-09-30
 */
@AllArgsConstructor
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

    private TokenUtil tokenUtil;
    private AreaMapper areaMapper;
    private SysMsgMapper sysMsgMapper;


    @Override
    public MemberVO login(MemberLoginForm memberForm) {
        Member member;
        // 根据用户名获取
        member = baseMapper.selectOne(Wrappers.<Member>lambdaQuery().eq(Member::getUsername, memberForm.getUsername())
                                                                .eq(Member::getState, Constants.Status.enable));
        if (Objects.isNull(member)) {
            throw new ApiException("该账号不存在");
        }
        if (!DigestUtil.encrypt(/*AesEncryptUtil.decrypt(*/memberForm.getPassword())/*)*/.equals(member.getPassword())) {
            // 先AES解密，在MD5,SHA1加密与数据库密码对比
            throw new ApiException( "输入的账号或密码错误");
        }
        MemberVO memberVO = new MemberVO();
        BeanUtils.copyProperties(member, memberVO);
        Integer count = sysMsgMapper.selectCount(Wrappers.<SysMsg>lambdaQuery()
            .eq(SysMsg::getUserId,member.getId())
            .eq(SysMsg::getStatus,1)
        );
        memberVO.setMsgCount(count);
        Area area = areaMapper.selectById(member.getAreaId());
        memberVO.setAreaName(area.getName());
        String token = tokenUtil.generateWebTokenAndCache(memberVO, SourceEnum.getEnumByType(1));
        memberVO.setAuthorization(token);
        return memberVO;
    }

    @Override
    public void save(MemberForm memberForm) {
        Member member =  new Member();
        Member vo = baseMapper.selectOne(Wrappers.<Member>lambdaQuery().eq(Member::getUsername, memberForm.getUsername())
                                                                       .eq(Member::getState,1));
        if (vo != null) {
            throw new ApiException("该账号已存在");
        }
        if(memberForm.getRole() == CommonConstant.Role.AREA){
            Member vos = baseMapper.selectOne(Wrappers.<Member>lambdaQuery().eq(Member::getRole, memberForm.getRole())
                                                                            .eq(Member::getState,CommonConstant.State.ENABLE)
                                                                             .eq(Member::getAreaId,memberForm.getAreaId()));
            if(vos != null){
                throw new ApiException("该园区已存在管理员");
            }
        }
        member.setState(CommonConstant.State.ENABLE);
        BeanUtils.copyProperties(memberForm, member);
        member.setPassword(DigestUtil.encrypt(memberForm.getPassword()));
        baseMapper.insert(member);
    }

    @Override
    public void update(MemberForm memberForm) {
        Member member =  new Member();
        Member vo = baseMapper.selectOne(Wrappers.<Member>lambdaQuery().eq(Member::getUsername, memberForm.getUsername())
                                                                       .eq(Member::getState,CommonConstant.State.ENABLE));
        if (vo == null) {
            throw new ApiException("该账号不存在");
        }
        if(memberForm.getRole() == CommonConstant.Role.AREA){
            Member vos = baseMapper.selectOne(Wrappers.<Member>lambdaQuery().eq(Member::getRole, memberForm.getRole())
                    .eq(Member::getState,CommonConstant.State.ENABLE)
                    .eq(Member::getAreaId,memberForm.getAreaId()));
            if(vos != null){
                throw new ApiException("该园区已存在管理员");
            }
        }
        BeanUtils.copyProperties(memberForm, member);
        baseMapper.updateById(member);
    }

    @Override
    public void delete(Long id) {
        Member member = baseMapper.selectById(id);
        MemberVO memberVO  = SessionCache.get();
        if(memberVO.getRole() != 1){
            if(memberVO.getRole() == 4 || memberVO.getRole() == 5){
                if( member.getRole() == 2 || member.getRole() == 3|| member.getRole() == 6){
                    throw new ApiException("暂无权限");
                }
            }else {
                if(member.getRole() == 4 || member.getRole() == 5 ){
                    throw new ApiException("暂无权限");
                }
            }
        }
        member.setState(CommonConstant.State.DELETE);
        baseMapper.updateById(member);
    }

    @Override
    public void updatePassWord(Long id, String password) {
        Member member = baseMapper.selectById(id);
        if(member == null){
            throw new ApiException("该账号不存在");
        }
        password = DigestUtil.encrypt(password);
        member.setPassword(password);
        baseMapper.updateById(member);
    }

    @Override
    public IPage getPage(PageQuery pageQuery, String name) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        LambdaQueryWrapper<Member> wrapper;
        if(role == CommonConstant.Role.SUPER || role == 6){
            wrapper = Wrappers.<Member>lambdaQuery().like(StringUtils.isNotBlank(name), Member::getUsername, name)
                                                    .eq(Member::getState,CommonConstant.State.ENABLE)
                                                    .orderByAsc(Member::getCreateTime);
        }else{
            wrapper = Wrappers.<Member>lambdaQuery().like(StringUtils.isNotBlank(name), Member::getUsername, name)
                                                    .eq(Member::getAreaId,session.getAreaId())
                                                    .eq(Member::getState, CommonConstant.State.ENABLE)
                                                    .orderByAsc(Member::getCreateTime);
        }
        IPage<Member> page = baseMapper.selectPage(pageQuery.loadPage(), wrapper);
        return page.convert(member -> {
            MemberVO memberVO = new MemberVO();
            BeanUtils.copyProperties(member, memberVO);
            Area area = areaMapper.selectById(member.getAreaId());
            memberVO.setAreaName(area.getName());
            return memberVO;
        });
    }

    @Override
    public void export(String name, HttpServletResponse response, HttpServletRequest request) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        List<Member> list = null;
        if(role == CommonConstant.Role.SUPER || role != 6){
             list = baseMapper.selectList(Wrappers.<Member>lambdaQuery().like(StringUtils.isNotBlank(name), Member::getUsername, name)
                    .eq(Member::getState,CommonConstant.State.ENABLE)
                    .orderByAsc(Member::getCreateTime)
            );
        }else{
             list = baseMapper.selectList(Wrappers.<Member>lambdaQuery().like(StringUtils.isNotBlank(name), Member::getUsername, name)
                    .eq(Member::getState,CommonConstant.State.ENABLE)
                    .eq(Member::getAreaId,session.getAreaId())
                    .orderByAsc(Member::getCreateTime)
            );
        }
        List<MemberVO> memberList =new ArrayList<>();
       list.forEach(member -> {
           MemberVO vo = new MemberVO();
           BeanUtils.copyProperties(member, vo);
           Area area = areaMapper.selectById(member.getAreaId());
           vo.setAreaName(area.getName());
           memberList.add(vo);
       });
        String[] titles = new String[]{"姓名", "ID", "联系电话", "所属区域"};
        String[] fields = {"username", "id", "phone", "areaName"};
        // 转化器
        Map<String, ExcelUtil.Converter> converters = new HashMap<>(16);
        ExcelUtil.exportExcel( "用户列表.xlsx", titles, fields, memberList, response, converters);
    }


}
