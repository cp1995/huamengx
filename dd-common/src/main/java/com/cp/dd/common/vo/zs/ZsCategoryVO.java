package com.cp.dd.common.vo.zs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "系统用户信息")
public class ZsCategoryVO  implements Serializable {


    @ApiModelProperty(value = "证书名称")
    private String name;

    @ApiModelProperty(value = "编码规则")
    private String code;

    @ApiModelProperty(value = "数量")
    private Integer zsNum;



}
