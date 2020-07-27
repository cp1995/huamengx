package com.cp.dd.common.vo.member;

import com.cp.dd.common.entity.member.Area;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "系统用户信息")
public class AreaVO extends Area implements Serializable {

    private static final long serialVersionUID = 1L;



    @ApiModelProperty(value = "园区名")
    private String areaName;




}
