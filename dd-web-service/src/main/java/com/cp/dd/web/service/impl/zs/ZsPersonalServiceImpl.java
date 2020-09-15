package com.cp.dd.web.service.impl.zs;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.entity.zs.ZsPersonal;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.zs.ZsPersonalMapper;
import com.cp.dd.web.form.zs.ZsPersonalForm;
import com.cp.dd.web.service.zs.IZsPersonalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


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
        BeanUtils.copyProperties(zsPersonalForm,zsTeachers);
        this.baseMapper.insert(zsTeachers);
    }

    @Override
    public void update(ZsPersonalForm zsPersonalForm) {

    }


}
