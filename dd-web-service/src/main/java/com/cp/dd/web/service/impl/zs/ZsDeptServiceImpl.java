package com.cp.dd.web.service.impl.zs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.entity.sys.SysArea;
import com.cp.dd.common.entity.zs.ZsDept;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.sys.SysAreaMapper;
import com.cp.dd.common.mapper.zs.ZsDeptMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.vo.zs.ZsDeptVO;
import com.cp.dd.web.form.zs.ZsDeptForm;
import com.cp.dd.web.service.zs.IZsDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-15
 */
@AllArgsConstructor
@Service
public class ZsDeptServiceImpl extends ServiceImpl<ZsDeptMapper, ZsDept> implements IZsDeptService {

    private SysAreaMapper sysAreaMapper;

    @Override
    public void save(ZsDeptForm zsDeptForm) {
        ZsDept zsDept = new ZsDept();
        ZsDept zsDept1 = this.baseMapper.selectOne(Wrappers.<ZsDept>lambdaQuery()
                .eq(ZsDept::getName,zsDeptForm.getName())
                .eq(ZsDept::getCategoryId,zsDeptForm.getCategoryId())
        );
        if(zsDept1 != null){
            throw new ApiException("该加盟商名称已存在");
        }
        BeanUtils.copyProperties(zsDeptForm,zsDept);
        if(StringUtils.isNoneBlank(zsDeptForm.getAreaCode())){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,zsDeptForm.getAreaCode()));
            zsDept.setShortCode(sysArea.getShortCode());
        }
        zsDept.setAuditStatus(1);
        this.baseMapper.insert(zsDept);
    }

    @Override
    public void wechatSave(ZsDeptForm zsDeptForm) {
        ZsDept zsDept = new ZsDept();
        ZsDept zsDept1 = this.baseMapper.selectOne(Wrappers.<ZsDept>lambdaQuery()
                .eq(ZsDept::getName,zsDeptForm.getName())
                .eq(ZsDept::getCategoryId,zsDeptForm.getCategoryId())
        );
        if(zsDept1 != null){
            throw new ApiException("该加盟商名称已存在");
        }
        BeanUtils.copyProperties(zsDeptForm,zsDept);
        if(StringUtils.isNoneBlank(zsDeptForm.getAreaCode())){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,zsDeptForm.getAreaCode()));
            zsDept.setShortCode(sysArea.getShortCode());
        }
        zsDept.setAuditStatus(0);
        this.baseMapper.insert(zsDept);
    }

    @Override
    public void update(ZsDeptForm zsDeptForm) {
        ZsDept zsDept = this.baseMapper.selectById(zsDeptForm.getId());
        BeanUtils.copyProperties(zsDeptForm,zsDept);
        if(StringUtils.isNoneBlank(zsDeptForm.getAreaCode())){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,zsDeptForm.getAreaCode()));
            zsDept.setShortCode(sysArea.getShortCode());
        }
        baseMapper.updateById(zsDept);

    }

    @Override
    public void wechatUpdate(ZsDeptForm zsDeptForm) {
        ZsDept zsDept = this.baseMapper.selectById(zsDeptForm.getId());
        BeanUtils.copyProperties(zsDeptForm,zsDept);
        if(StringUtils.isNoneBlank(zsDeptForm.getAreaCode())){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,zsDeptForm.getAreaCode()));
            zsDept.setShortCode(sysArea.getShortCode());
        }
        baseMapper.updateById(zsDept);
    }

    @Override
    public ZsDeptVO detail(Long id) {
        return this.baseMapper.detail(id);
    }

    @Override
    public IPage<ZsDeptVO> getPage(PageQuery query, Long categoryId, String status,String areaCode) {
        String shortCode = null;
        if(StringUtils.isNotBlank(areaCode)){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,areaCode));
            shortCode = sysArea.getShortCode();
        }
        return this.baseMapper.getPage(query.loadPage(),categoryId,status,shortCode);
    }

    @Override
    public IPage<ZsDeptVO> auditPage(PageQuery query, Long categoryId, String status,Integer auditStatus,String areaCode) {
        String shortCode = null;
        if(StringUtils.isNotBlank(areaCode)){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,areaCode));
            shortCode = sysArea.getShortCode();
        }
        return this.baseMapper.getAuditPage(query.loadPage(),categoryId,status,auditStatus,shortCode);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void audit(List<Long> ids, Integer auditStatus) {
        ids.forEach(id->{
            this.audit(id,auditStatus);
        });
    }

    @Transactional(rollbackFor = Exception.class)
    public void audit(Long id,Integer auditStatus) {
        ZsDept entity = baseMapper.selectById(id);
        if (Objects.isNull(entity)) {
            throw new ApiException(-1, "加盟商不存在");
        }
        // 修改状态，逻辑删除
        entity.setAuditStatus(auditStatus);
        this.updateById(entity);
    }
}
