package com.cp.dd.common.mapper.zs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.cp.dd.common.entity.zs.ZsPersonal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.dd.common.vo.zs.ZsPersonalVO;
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
public interface ZsPersonalMapper extends BaseMapper<ZsPersonal> {

    ZsPersonalVO detail(Long id);

    IPage<ZsPersonalVO> getPage(IPage<ZsPersonal> page,
                          @Param("name") String name,
                          @Param("status") Integer status,
                                @Param("categoryId") Long categoryId,
                                @Param("shortCode") String shortCode

    );

    List<ZsPersonalVO> getName(String name);

}
