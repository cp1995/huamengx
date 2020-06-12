package com.cp.dd.common.mapper.member;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cp.dd.common.entity.sys.SysLog;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 园区信息 Mapper 接口
 * </p>
 *
 * @author CodeGenerator
 * @date 2019-10-08
 */
public interface SysLogMapper extends BaseMapper<SysLog> {

    Page<SysLog> getPage(IPage<SysLog> page, @Param("createBy")String createBy,
                                             @Param("memberId")Long memberId,
                                             @Param("resultCode")Integer resultCode,
                                             @Param("startTime")LocalDate startTime,
                                             @Param("endTime")LocalDate endTime);

    List<SysLog> getList(@Param("createBy")String createBy,
                         @Param("memberId")Long memberId,
                         @Param("resultCode")Integer resultCode,
                         @Param("startTime")LocalDate startTime,
                         @Param("endTime")LocalDate endTime);

}
