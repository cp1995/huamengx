package com.cp.dd.common.vo.sport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "系统用户信息")
public class CountVO  implements Serializable {

    private static final long serialVersionUID = 1L;



    @ApiModelProperty(value = "男总数")
    private Integer nanTotal;

    @ApiModelProperty(value = "男合格数")
    private Integer nanHg;

    @ApiModelProperty(value = "女总数")
    private Integer nvTotal;

    @ApiModelProperty(value = "女合格数")
    private Integer nvHg;




}
