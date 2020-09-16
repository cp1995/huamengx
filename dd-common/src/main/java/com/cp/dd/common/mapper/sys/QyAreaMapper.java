package com.cp.dd.common.mapper.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.entity.sys.QyArea;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 区域设置 Mapper 接口
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-16
 */
public interface QyAreaMapper extends BaseMapper<QyArea> {

    IPage<QyArea> getPage(IPage<QyArea> page

    );

}
