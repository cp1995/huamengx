package com.cp.dd.web.service.impl.zs;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.constant.Constants;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.cp.dd.common.entity.zs.ZsPersonal;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.zs.ZsPersonalMapper;
import com.cp.dd.web.form.zs.ZsPersonalForm;
import com.cp.dd.web.service.zs.IZsPersonalService;
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
 * @date 2020-09-15
 */
@AllArgsConstructor
@Service
public class ZsPersonalServiceImpl extends ServiceImpl<ZsPersonalMapper, ZsPersonal> implements IZsPersonalService {

    @Override
    public void save(ZsPersonalForm zsPersonalForm) {
        ZsPersonal zsTeachers = new ZsPersonal();
        ZsPersonal zsTeachers1 = this.baseMapper.selectOne(Wrappers.<ZsPersonal>lambdaQuery()
                .eq(ZsPersonal::getName,zsPersonalForm.getName())
        );
        if(zsTeachers1 != null){
            throw new ApiException("该姓名已存在");
        }
        zsTeachers.setStatus(1);
        BeanUtils.copyProperties(zsPersonalForm,zsTeachers);
        this.baseMapper.insert(zsTeachers);
    }

    @Override
    public void update(ZsPersonalForm zsPersonalForm) {

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void del(List<Long> ids) {
        ids.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void audit(List<Long> ids, Integer auditStatus) {
        ids.forEach(id->{
            this.audit(id,auditStatus);
        });
    }
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long actId) {
        ZsPersonal entity = baseMapper.selectById(actId);
        if (Objects.isNull(entity)) {
            throw new ApiException(-1, "该证书不存在");
        }
        // 修改状态，逻辑删除
        entity.setStatus(Constants.Status.delete);
        this.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void audit(Long id,Integer auditStatus) {
        ZsPersonal entity = baseMapper.selectById(id);
        if (Objects.isNull(entity)) {
            throw new ApiException(-1, "该证书不存在");
        }
        // 修改状态，逻辑删除
        entity.setStatus(auditStatus);
        this.updateById(entity);
    }


}
