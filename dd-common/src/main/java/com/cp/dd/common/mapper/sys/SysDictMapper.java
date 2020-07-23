package com.cp.dd.common.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.dd.common.entity.sys.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-07-05
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

    /**
     * 根据code查询字典
     *
     * @param code code
     * @return 列表
     */
    List<SysDict> selectSysDictByCode(@Param("code") String code);
}
