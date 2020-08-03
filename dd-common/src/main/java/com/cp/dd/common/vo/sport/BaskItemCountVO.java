package com.cp.dd.common.vo.sport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "篮球项目统计")
public class BaskItemCountVO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "男总数")
    private Integer nanTotal;

    @ApiModelProperty(value = "女总数")
    private Integer nvTotal;










}
