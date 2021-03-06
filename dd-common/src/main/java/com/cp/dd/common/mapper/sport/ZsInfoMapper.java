package com.cp.dd.common.mapper.sport;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cp.dd.common.entity.sport.ZsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cp.dd.common.vo.sport.ZsInfoAreaCountVO;
import com.cp.dd.common.vo.sport.ZsInfoCountVO;
import com.cp.dd.common.vo.sport.ZsInfoLsCountVO;
import com.cp.dd.common.vo.zs.ZsPersonalVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
                          @Param("deptName") String deptName,
                          @Param("code") String code,
                          @Param("areaId") String areaId,
                          @Param("categoryType") String categoryType,
                          @Param("categoryId") Long categoryId

                          );


    IPage<ZsPersonalVO> getAuditPage(IPage<ZsInfo> page,
                                     @Param("name") String name,
                                     @Param("deptName") String deptName,
                                     @Param("code") String code,
                                     @Param("areaId") String areaId,
                                     @Param("categoryType") String categoryType,
                                     @Param("auditStatus") Integer auditStatus,
                                     @Param("shortCode") String shortCode
    );

    List<ZsInfo> getAppList(
            @Param("name") String name,
            @Param("deptName") String deptName,
            @Param("code") String code

    );

    List<ZsInfoCountVO> countInfo( @Param("areaId")String areaId);

    List<ZsInfoAreaCountVO> countArea();

    ZsInfoLsCountVO countLx(@Param("year")String year);

}
