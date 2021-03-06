package com.cp.dd.web.service.impl.sport;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.constant.Constants;
import com.cp.dd.common.entity.member.Member;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.cp.dd.common.entity.sys.SysArea;
import com.cp.dd.common.entity.zs.ZsPersonal;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.sport.ZsInfoMapper;
import com.cp.dd.common.mapper.sys.SysAreaMapper;
import com.cp.dd.common.mapper.zs.ZsPersonalMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.common.vo.sport.ZsInfoAreaCountVO;
import com.cp.dd.common.vo.sport.ZsInfoCountVO;
import com.cp.dd.common.vo.sport.ZsInfoLsCountVO;
import com.cp.dd.common.vo.zs.ZsPersonalVO;
import com.cp.dd.web.form.sport.WechatZsInfoForm;
import com.cp.dd.web.form.sport.ZsInfoForm;
import com.cp.dd.web.service.sport.IZsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-07-23
 */
@AllArgsConstructor
@Service
public class ZsInfoServiceImpl extends ServiceImpl<ZsInfoMapper, ZsInfo> implements IZsInfoService {

    private ZsPersonalMapper zsPersonalMapper;
    private SysAreaMapper sysAreaMapper;

    @Override
    public void save(ZsInfoForm zsInfoForm) {
        MemberVO member = SessionCache.get();
        if(member.getRole() != 5){
            throw new ApiException("总部管理员才能进行录入");
        }
        ZsInfo zsInfo = new ZsInfo();
        BeanUtils.copyProperties(zsInfoForm, zsInfo);
        this.baseMapper.insert(zsInfo);
    }


    @Override
    public void weChatSave(WechatZsInfoForm zsInfoForm) {
        MemberVO member = SessionCache.get();
        ZsInfo zsInfo = new ZsInfo();
        BeanUtils.copyProperties(zsInfoForm, zsInfo);
        zsInfo.setCategoryType("个人证书");
        this.baseMapper.insert(zsInfo);
    }

    @Override
    public void update(ZsInfoForm zsInfoForm) {
        MemberVO member = SessionCache.get();
        if(member.getRole() != 5){
            throw new ApiException("总部管理员才能进行编辑");
        }
        ZsInfo zsInfo = this.baseMapper.selectById(zsInfoForm.getId());
        if(zsInfo == null){
            throw new ApiException("该证书不存在");
        }
        BeanUtils.copyProperties(zsInfoForm, zsInfo);
        this.baseMapper.updateById(zsInfo);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void del(List<Long> ids) {
        MemberVO memberVO  = SessionCache.get();
        if(memberVO.getRole() != 1){
            throw new ApiException("暂无权限删除");
        }
        ids.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void audit(List<Long> ids, Integer auditStatus) {
        MemberVO memberVO = SessionCache.get();
        ids.forEach(id->{
            this.audit(id,auditStatus);
        });

    }

    @Override
    public IPage<ZsInfo> getPage(PageQuery query, String name, String deptName, String code, String areaId, String categoryType,Long categoryId) {
        MemberVO memberVO = SessionCache.get();
        if(memberVO.getRole()  == 4){
            areaId = memberVO.getAreaId()+"";
        }
        return this.baseMapper.getPage(query.loadPage(),name,deptName,code,areaId,categoryType,categoryId);
    }

    @Override
    public IPage<ZsPersonalVO> getAuditPage(PageQuery query, String name, String deptName, String code, String categoryType, Integer auditStatus,String areaCode) {
       MemberVO memberVO = SessionCache.get();
         String areaId = null;
//       if(memberVO.getRole()  == 4){
//           areaId = memberVO.getAreaId()+"";
//       }
        String shortCode = null;
        if(StringUtils.isNotBlank(areaCode)){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,areaCode));
            shortCode = sysArea.getShortCode();
        }
        return this.baseMapper.getAuditPage(query.loadPage(),name,deptName,code,areaId,categoryType,auditStatus,shortCode);
    }

    @Override
    public List<ZsInfo> getAppList(String name, String deptName, String code) {
        return this.baseMapper.getAppList(name,deptName,code);
    }

    @Override
    public List<ZsInfoCountVO> countInfo() {
        MemberVO memberVO = SessionCache.get();
        String areaId = null;
        if (memberVO.getRole() == 4){
            areaId = memberVO.getAreaId()+"";
        }
        return this.baseMapper.countInfo(areaId);
    }

    @Override
    public  List<ZsInfoAreaCountVO>  countArea() {
        MemberVO memberVO = SessionCache.get();
        String areaId = null;
//        if (memberVO.getRole() == 4){
//            areaId = memberVO.getAreaId()+"";
//        }
        return this.baseMapper.countArea();
    }

    @Override
    public ZsInfoLsCountVO countLx(String year) {
        if(StringUtils.isBlank(year)){
            year = "2020";
        }
        return this.baseMapper.countLx(year);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        ZsInfo entity = baseMapper.selectById(id);
        if (Objects.isNull(entity)) {
            throw new ApiException(-1, "该证书不存在");
        }
        this.baseMapper.deleteById(id);
        // 修改状态，逻辑删除
       /* entity.setStatus(Constants.Status.delete);
        this.updateById(entity);*/
    }

    @Transactional(rollbackFor = Exception.class)
    public void audit(Long id,Integer auditStatus) {
        ZsPersonal entity = zsPersonalMapper.selectById(id);
        if (Objects.isNull(entity)) {
            throw new ApiException(-1, "该证书不存在");
        }
        // 修改状态，逻辑删除
        entity.setStatus(auditStatus);
        entity.setStartTime(LocalDate.now());
        entity.setEndTime(LocalDate.now().plus(2, ChronoUnit.YEARS));
        zsPersonalMapper.updateById(entity);
    }


}
