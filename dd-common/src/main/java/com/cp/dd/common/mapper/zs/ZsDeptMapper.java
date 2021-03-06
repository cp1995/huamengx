package com.cp.dd.common.mapper.zs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.entity.zs.ZsDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.dd.common.vo.zs.ZsDeptVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-15
 */
public interface ZsDeptMapper extends BaseMapper<ZsDept> {

    IPage<ZsDeptVO> getPage(IPage<ZsDept> page,
                            @Param("categoryId") Long categoryId,
                            @Param("status") String status,
                            @Param("shortCode") String shortCode

    );

    IPage<ZsDeptVO> getAuditPage(IPage<ZsDept> page,
                            @Param("categoryId") Long categoryId,
                            @Param("status") String status,
                            @Param("auditStatus") Integer auditStatus,
                             @Param("shortCode") String shortCode

    );

    ZsDeptVO detail(Long id);

    List<ZsDeptVO> getName(String name);

}
