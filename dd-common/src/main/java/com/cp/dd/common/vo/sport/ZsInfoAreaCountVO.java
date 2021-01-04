package com.cp.dd.common.vo.sport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "证书区域总数统计")
public class ZsInfoAreaCountVO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "区域名称")
    private String name;

    @ApiModelProperty(value = "数量")
    private Integer  areaTotal;









}
