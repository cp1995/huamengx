package com.cp.dd.web.service.impl.sport;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.constant.Constants;
import com.cp.dd.common.entity.member.Member;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.sport.ZsInfoMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.common.vo.sport.ZsInfoAreaCountVO;
import com.cp.dd.common.vo.sport.ZsInfoCountVO;
import com.cp.dd.common.vo.sport.ZsInfoLsCountVO;
import com.cp.dd.web.form.sport.ZsInfoForm;
import com.cp.dd.web.service.sport.IZsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        ids.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void audit(List<Long> ids, Integer auditStatus) {
        MemberVO memberVO = SessionCache.get();
        if(memberVO.getRole()  != 4){
            throw new ApiException("暂无审核权限");
        }

        ids.forEach(id->{
            this.audit(id,auditStatus);
        });

    }

    @Override
    public IPage<ZsInfo> getPage(PageQuery query, String name, String deptName, String code, String areaId, String categoryType) {
        MemberVO memberVO = SessionCache.get();
        if(memberVO.getRole()  == 4){
            areaId = memberVO.getAreaId()+"";
        }
        return this.baseMapper.getPage(query.loadPage(),name,deptName,code,areaId,categoryType);
    }

    @Override
    public IPage<ZsInfo> getAuditPage(PageQuery query, String name, String deptName, String code, String categoryType,Integer auditStatus) {
       MemberVO memberVO = SessionCache.get();
         String areaId = null;
       if(memberVO.getRole()  == 4){
           areaId = memberVO.getAreaId()+"";
       }
        return this.baseMapper.getAuditPage(query.loadPage(),name,deptName,code,areaId,categoryType,auditStatus);
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
    public ZsInfoAreaCountVO countArea() {
        MemberVO memberVO = SessionCache.get();
        String areaId = null;
//        if (memberVO.getRole() == 4){
//            areaId = memberVO.getAreaId()+"";
//        }
        return this.baseMapper.countArea(areaId);
    }

    @Override
    public ZsInfoLsCountVO countLx(String year) {
        if(StringUtils.isBlank(year)){
            year = "2020";
        }
        return this.baseMapper.countLx(year);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long actId) {
        ZsInfo entity = baseMapper.selectById(actId);
        if (Objects.isNull(entity)) {
            throw new ApiException(-1, "该证书不存在");
        }
        // 修改状态，逻辑删除
        entity.setStatus(Constants.Status.delete);
        this.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void audit(Long id,Integer auditStatus) {
        ZsInfo entity = baseMapper.selectById(id);
        if (Objects.isNull(entity)) {
            throw new ApiException(-1, "该证书不存在");
        }
        // 修改状态，逻辑删除
        entity.setAuditStatus(auditStatus);
        this.updateById(entity);
    }


}
