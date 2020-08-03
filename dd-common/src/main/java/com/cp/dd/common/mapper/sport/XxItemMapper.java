package com.cp.dd.common.mapper.sport;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cp.dd.common.entity.sport.XxItem;
import com.cp.dd.common.vo.sport.CountVO;
import com.cp.dd.common.vo.sport.MonthVO;
import com.cp.dd.common.vo.sport.XxItemCountVO;
import com.cp.dd.common.vo.sport.XxItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 园区信息 Mapper 接口
 * </p>
 *
 * @author CodeGenerator
 * @date 2019-10-08
 */
public interface XxItemMapper extends BaseMapper<XxItem> {

    Page<XxItemVO> getPage(IPage<XxItemVO> page,
                           @Param("childName") String childName,
                           @Param("phone") String phone,
                           @Param("name") String name,
                           @Param("createBy") String createBy,
                           @Param("parentName") String parentName,
                           @Param("areaId") Long areaId);

    Page<XxItemVO> getDataPage(IPage<XxItemVO> page,
                             @Param("childName") String childName,
                             @Param("phone") String phone,
                             @Param("name") String name,
                             @Param("createBy") String createBy,
                             @Param("areaId") Long areaId,
                             @Param("orderBy") String orderBy
    );

    List<XxItemVO> getDataList(
            @Param("childName") String childName,
            @Param("phone") String phone,
            @Param("name") String name,
            @Param("createBy") String createBy,
            @Param("areaId") Long areaId,
            @Param("orderBy") String orderBy
    );


    List<XxItemVO> getData(@Param("childName") String childName,
                         @Param("phone") String phone,
                         @Param("sportId") Long sportId);

    XxItemVO detail(Long id);

    CountVO countTotal(@Param("start")Integer start,
                       @Param("end")Integer end);


    XxItemCountVO getItemCount(@Param("start")Integer start,
                               @Param("end")Integer end);

    MonthVO countMonth(@Param("year")String year);


}
