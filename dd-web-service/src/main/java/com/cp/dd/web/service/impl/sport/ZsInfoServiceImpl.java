package com.cp.dd.web.service.impl.sport;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.constant.Constants;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.cp.dd.common.entity.sys.SysArea;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.sport.ZsInfoMapper;
import com.cp.dd.common.mapper.sys.SysAreaMapper;
import com.cp.dd.common.support.PageQuery;
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

    private SysAreaMapper sysAreaMapper;


    @Override
    public void save(ZsInfoForm zsInfoForm) {
        ZsInfo zsInfo = new ZsInfo();
        BeanUtils.copyProperties(zsInfoForm, zsInfo);
        SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                .eq(SysArea::getCode,zsInfoForm.getCode()));
        zsInfo.setShortCode(sysArea.getShortCode());
        this.baseMapper.insert(zsInfo);
    }

    @Override
    public void update(ZsInfoForm zsInfoForm) {
        ZsInfo zsInfo = this.baseMapper.selectById(zsInfoForm.getId());
        if(zsInfo == null){
            throw new ApiException("该证书不存在");
        }
        BeanUtils.copyProperties(zsInfoForm, zsInfo);
        SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                .eq(SysArea::getCode,zsInfoForm.getCode()));
        zsInfo.setShortCode(sysArea.getShortCode());
        this.baseMapper.updateById(zsInfo);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void del(List<Long> ids) {
        ids.forEach(this::delete);
    }

    @Override
    public IPage<ZsInfo> getPage(PageQuery query, String name, String code, String address, String areaCode, String categoryType, String mobile) {
        if(StringUtils.isNotBlank(areaCode)){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,areaCode));
            areaCode = sysArea.getShortCode();
        }
        return this.baseMapper.getPage(query.loadPage(),name,code,address,areaCode,categoryType,mobile);
    }

    public void delete(Long actId) {
        ZsInfo entity = baseMapper.selectById(actId);
        if (Objects.isNull(entity)) {
            throw new ApiException(-1, "该分类不存在");
        }
        // 修改状态，逻辑删除
        entity.setStatus(Constants.Status.delete);
        this.updateById(entity);
    }


}
