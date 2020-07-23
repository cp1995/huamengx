package com.cp.dd.web.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.dd.common.entity.sys.SysDict;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.sys.SysDictMapper;
import com.cp.dd.web.service.sys.ISysDictService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author chengp
 * @date 2020-07-05
 */
@AllArgsConstructor
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {


    @Override
    public List<SysDict> listByCode(String code) {
        return baseMapper.selectList(Wrappers.<SysDict>lambdaQuery()
                .eq(SysDict::getCode, code)
                .eq(SysDict::getIsDeleted, false)
                // 默认按sort排序
                .orderByAsc(SysDict::getSort));
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void sort(Long id, String upOrDown) {
        SysDict sysDict = baseMapper.selectById(id);
        if (sysDict == null) {
            throw new ApiException("字典不存在");
        }

        LambdaQueryWrapper<SysDict> wrapper = Wrappers.<SysDict>lambdaQuery().eq(SysDict::getCode, sysDict.getCode());
        List<SysDict> sysDicts;
        switch (upOrDown) {
            case "up":
                sysDicts = baseMapper.selectList(wrapper.lt(SysDict::getSort, sysDict.getSort()).orderByDesc(SysDict::getSort).eq(SysDict::getIsDeleted, false));
                break;
            case "down":
                sysDicts = baseMapper.selectList(wrapper.gt(SysDict::getSort, sysDict.getSort()).orderByAsc(SysDict::getSort).eq(SysDict::getIsDeleted, false));
                break;
            default:
                return;
        }

        // 替换
        if (sysDicts != null && !sysDicts.isEmpty()) {
            SysDict reSysDict = sysDicts.get(0);
            Integer temp = reSysDict.getSort();
            reSysDict.setSort(sysDict.getSort());
            sysDict.setSort(temp);
            baseMapper.updateById(reSysDict);
            baseMapper.updateById(sysDict);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdate(SysDict sysDict) {
        if (sysDict.getId() == null) {
            IPage<SysDict> page = baseMapper.selectPage(new Page<>(1, 1), Wrappers.<SysDict>lambdaQuery().eq(SysDict::getCode, sysDict.getCode()).orderByDesc(SysDict::getSort));
            sysDict.setSort(page.getTotal() > 0 ? page.getRecords().get(0).getSort() + 1 : 1);
            baseMapper.insert(sysDict);
        } else if (getById(sysDict.getId()) == null) {
            throw new ApiException("该记录不存在");
        }
        return super.saveOrUpdate(sysDict);
    }

    @Override
    public void delete(Long id) {
        SysDict sysDict = baseMapper.selectById(id);
        sysDict.setIsDeleted(true);
        baseMapper.updateById(sysDict);
        }
}
