package com.cp.dd.web.service.impl.member;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.constant.Constants;
import com.cp.dd.common.entity.member.ZsCategory;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.member.ZsCategoryMapper;
import com.cp.dd.web.form.member.ZsCategoryForm;
import com.cp.dd.web.service.member.IZsCategoryService;
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
public class ZsCategoryServiceImpl extends ServiceImpl<ZsCategoryMapper, ZsCategory> implements IZsCategoryService {

    @Override
    public void save(ZsCategoryForm zsCategoryForm) {
        ZsCategory zsCategory = new ZsCategory();
        checkName(zsCategoryForm.getName());
        BeanUtils.copyProperties(zsCategoryForm, zsCategory);
        this.baseMapper.insert(zsCategory);

    }

    @Override
    public void update(ZsCategoryForm zsCategoryForm) {
        ZsCategory zsCategory = this.baseMapper.selectById(zsCategoryForm.getId());
        if(zsCategory == null){
            throw new ApiException("该分类不存在");
        }
        if(!zsCategory.getName().equals(zsCategoryForm.getName())){
            this.checkName(zsCategoryForm.getName());
        }
        BeanUtils.copyProperties(zsCategoryForm, zsCategory);
        this.baseMapper.updateById(zsCategory);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void del(List<Long> ids) {
        ids.forEach(this::delete);
    }


    public void checkName(String name){
        ZsCategory entity = this.baseMapper.selectOne(Wrappers.<ZsCategory>lambdaQuery()
                .eq(ZsCategory::getName,name)
                .ne(ZsCategory::getStatus, Constants.Status.delete));
        if(entity != null){
            throw new ApiException("该分类名称已存在");
        }
    }

    public void delete(Long actId) {
        ZsCategory entity = baseMapper.selectById(actId);
        if (Objects.isNull(entity)) {
            throw new ApiException(-1, "该分类不存在");
        }
        // 修改状态，逻辑删除
        entity.setStatus(Constants.Status.delete);
        this.updateById(entity);
    }

}
