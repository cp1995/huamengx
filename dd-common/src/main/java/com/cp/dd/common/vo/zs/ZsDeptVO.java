package com.cp.dd.common.vo.zs;

import com.cp.dd.common.entity.zs.ZsDept;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "系统用户信息")
public class ZsDeptVO extends ZsDept implements Serializable {


    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = " 区域名")
    private String areaName;



}
