package com.cp.dd.web.service.impl.zs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.entity.zs.ZsDept;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.zs.ZsDeptMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.vo.zs.ZsDeptVO;
import com.cp.dd.web.form.zs.ZsDeptForm;
import com.cp.dd.web.service.zs.IZsDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

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


    @Override
    public void save(ZsDeptForm zsDeptForm) {
        ZsDept zsDept = new ZsDept();
        ZsDept zsDept1 = this.baseMapper.selectOne(Wrappers.<ZsDept>lambdaQuery()
                .eq(ZsDept::getName,zsDeptForm.getName())
        );
        if(zsDept1 != null){
            throw new ApiException("该加盟商名称已存在");
        }
        BeanUtils.copyProperties(zsDeptForm,zsDept);
        zsDept.setAuditStatus(1);
        this.baseMapper.insert(zsDept);
    }

    @Override
    public void update(ZsDeptForm zsDeptForm) {

    }

    @Override
    public IPage<ZsDeptVO> getPage(PageQuery query, Long categoryId, String status) {
        return this.baseMapper.getPage(query.loadPage(),categoryId,status);
    }
}
