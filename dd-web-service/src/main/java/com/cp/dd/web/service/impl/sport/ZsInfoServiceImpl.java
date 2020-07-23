package com.cp.dd.web.service.impl.sport;

import com.cp.dd.common.constant.Constants;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.sport.ZsInfoMapper;
import com.cp.dd.web.form.sport.ZsInfoForm;
import com.cp.dd.web.service.sport.IZsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
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
        ZsInfo zsInfo = new ZsInfo();
        BeanUtils.copyProperties(zsInfoForm, zsInfo);
        this.baseMapper.insert(zsInfo);
    }

    @Override
    public void update(ZsInfoForm zsInfoForm) {
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
