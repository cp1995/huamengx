package com.cp.dd.common.mapper.zs;

import com.cp.dd.common.entity.zs.ZsPersonal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.dd.common.vo.zs.ZsPersonalVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-15
 */
public interface ZsPersonalMapper extends BaseMapper<ZsPersonal> {

    ZsPersonalVO detail(Long id);

}
