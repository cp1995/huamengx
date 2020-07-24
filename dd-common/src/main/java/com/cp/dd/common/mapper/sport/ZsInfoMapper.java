package com.cp.dd.common.mapper.sport;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-07-23
 */
public interface ZsInfoMapper extends BaseMapper<ZsInfo> {

    IPage<ZsInfo> getPage(IPage<ZsInfo> page,
                          @Param("name") String name,
                          @Param("code") String code,
                          @Param("address") String address,
                          @Param("shortCode") String shortCode,
                          @Param("categoryType") String categoryType,
                          @Param("mobile") String mobile);

}
