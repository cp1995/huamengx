package com.cp.dd.web.service.impl.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.entity.sys.QyArea;
import com.cp.dd.common.entity.sys.SysArea;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.sys.QyAreaMapper;
import com.cp.dd.common.mapper.sys.SysAreaMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.web.service.sys.IQyAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 区域设置 服务实现类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-16
 */
@AllArgsConstructor
@Service
public class QyAreaServiceImpl extends ServiceImpl<QyAreaMapper, QyArea> implements IQyAreaService {

    private SysAreaMapper sysAreaMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(String name, String province) {
        QyArea qyArea = new QyArea();
        qyArea.setName(name);
        String[] areaName = province.split(",");
        for (String string : areaName) {
            SysArea sysArea =  sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                .eq(SysArea::getName,string)
                .eq(SysArea::getGrade,1)
            );
            if(sysArea == null){
                throw new ApiException("该区域不存在");
            }
            qyArea.setProvince(sysArea.getName());
            qyArea.setProvinceCode(sysArea.getCode());
            this.baseMapper.insert(qyArea);
        }
    }

    @Override
    public IPage<QyArea> getPage(PageQuery query) {
        return this.baseMapper.getPage(query.loadPage());
    }
}
