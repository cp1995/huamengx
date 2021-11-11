package com.cp.dd.web.service.impl.member;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.dd.common.constant.CommonConstant;
import com.cp.dd.common.entity.member.Area;
import com.cp.dd.common.entity.member.Member;
import com.cp.dd.common.entity.sys.SysArea;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.member.AreaMapper;
import com.cp.dd.common.mapper.member.MemberMapper;
import com.cp.dd.common.mapper.sys.SysAreaMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.AreaVO;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.web.service.member.IAreaService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;


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
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements IAreaService {

    private  MemberMapper memberMapper;
    private SysAreaMapper sysAreaMapper;

    @Override
    public List<Area> findList() {
        List<Area> list= null;
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role == CommonConstant.Role.SUPER){
            list = baseMapper.selectList(Wrappers.<Area>lambdaQuery()
                    .eq(Area::getState,CommonConstant.State.ENABLE)
                    .ne(Area::getType,"区域")
                    .orderByDesc(Area::getCreateTime));
        }else{
            list = baseMapper.selectList(Wrappers.<Area>lambdaQuery()
                    .eq(Area::getState,CommonConstant.State.ENABLE)
                    .eq(Area::getId,session.getAreaId())
                    .ne(Area::getType,"区域")
                    .orderByDesc(Area::getCreateTime));
        }
        return list;
    }

    @Override
    public List<Area> findRegionList() {
        List<Area> list= null;
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role == CommonConstant.Role.SUPER){
            list = baseMapper.selectList(Wrappers.<Area>lambdaQuery()
                    .eq(Area::getState,CommonConstant.State.ENABLE)
                    .eq(Area::getType,"区域")
                    .orderByDesc(Area::getCreateTime));
        }else{
            list = baseMapper.selectList(Wrappers.<Area>lambdaQuery()
                    .eq(Area::getState,CommonConstant.State.ENABLE)
                   // .eq(Area::getId,session.getAreaId())
                    .eq(Area::getType,"区域")
                    .orderByDesc(Area::getCreateTime));
        }
        return list;
    }

    @Override
    public void  delete(Long id) {
        MemberVO memberVO  = SessionCache.get();
        if(memberVO.getRole() != 1){
            throw new ApiException("暂无权限删除");
        }
        Area area = baseMapper.selectById(id);
        List<Member> list = memberMapper.selectList(Wrappers.<Member>lambdaQuery().eq(Member::getAreaId,area.getId())
                                                                            .eq(Member::getState,CommonConstant.State.ENABLE));
        if(list.size()>0){
            throw new ApiException("该园区下有数据,不能删除");
        }
       /* area.setState(CommonConstant.State.DELETE);
        baseMapper.updateById(area);*/
        this.baseMapper.deleteById(id);
    }

    @Override
    public void save(String name,String areaCode,String type) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role != CommonConstant.Role.SUPER && role != CommonConstant.Role.zg){
            throw new ApiException("暂无权限");
        }
        SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                .eq(SysArea::getCode,areaCode));
        Area area = new Area();
        area.setName(name);
        area.setAreaCode(areaCode);
        area.setType(type);
        area.setShortCode(sysArea.getShortCode());
        area.setState(CommonConstant.State.ENABLE);
        this.baseMapper.insert(area);
    }

    @Override
    public void update(Long id,String name,String areaCode,String type) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role != CommonConstant.Role.SUPER && role != CommonConstant.Role.zg){
            throw new ApiException("暂无权限");
        }
        SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                .eq(SysArea::getCode,areaCode));
        Area area = this.baseMapper.selectById(id);
        area.setName(name);
        area.setAreaCode(areaCode);
        area.setType(type);
        area.setShortCode(sysArea.getShortCode());
        this.baseMapper.updateById(area);
    }

    @Override
    public IPage<AreaVO> getPage(PageQuery pageQuery, String name) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        LambdaQueryWrapper<Area> wrapper;
        if(role == CommonConstant.Role.SUPER && role == CommonConstant.Role.zg){
            wrapper = Wrappers.<Area>lambdaQuery().like(StringUtils.isNotBlank(name), Area::getName, name)
                    .eq(Area::getState,CommonConstant.State.ENABLE)
                    .ne(Area::getType,"区域")
                    .orderByAsc(Area::getCreateTime);
        }else{
            wrapper = Wrappers.<Area>lambdaQuery().like(StringUtils.isNotBlank(name), Area::getName, name)
                    .eq(Area::getState,CommonConstant.State.ENABLE)
                    .ne(Area::getType,"区域")
                    .eq(Area::getId,session.getAreaId())
                    .orderByAsc(Area::getCreateTime);
        }

        IPage<Area> page = baseMapper.selectPage(pageQuery.loadPage(), wrapper);
        return page.convert(area -> {
            AreaVO areaVO = new AreaVO();
            BeanUtils.copyProperties(area, areaVO);
            SysArea sysArea =sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,area.getAreaCode()));
            String code = sysArea.getCode();
            if(sysArea.getGrade().equals("3")){
                SysArea sysArea1 =sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                        .eq(SysArea::getCode,sysArea.getParentCode()));
                code = sysArea1.getParentCode() + "-" + sysArea1.getCode() + "-" + code;
            }
            if(sysArea.getGrade().equals("2")){
                code = sysArea.getParentCode() + "-" + code;
            }
            areaVO.setAreaCode(code);
            areaVO.setAreaName(sysArea.getFullName());
            return areaVO;
        });
    }
}
