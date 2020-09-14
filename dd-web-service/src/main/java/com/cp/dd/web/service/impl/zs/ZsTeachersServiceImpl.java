package com.cp.dd.web.service.impl.zs;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.entity.zs.ZsTeachers;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.zs.ZsTeachersMapper;
import com.cp.dd.web.form.zs.ZsTeachersForm;
import com.cp.dd.web.service.zs.IZsTeachersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-14
 */
@AllArgsConstructor
@Service
public class ZsTeachersServiceImpl extends ServiceImpl<ZsTeachersMapper, ZsTeachers> implements IZsTeachersService {

    @Override
    public void save(ZsTeachersForm zsTeachersForm) {
        ZsTeachers zsTeachers = new ZsTeachers();
        ZsTeachers zsTeachers1 = this.baseMapper.selectOne(Wrappers.<ZsTeachers>lambdaQuery()
            .eq(ZsTeachers::getName,zsTeachersForm.getName())
        );
        if(zsTeachers1 != null){
            throw new ApiException("该姓名已存在");
        }
        BeanUtils.copyProperties(zsTeachersForm,zsTeachers);
        zsTeachers.setRzTime(LocalDate.now());
        this.baseMapper.insert(zsTeachers);
    }

    @Override
    public void importItem(MultipartFile file) {

    }


}
