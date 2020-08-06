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


    @ApiModelProperty(value = "东部")
    private Integer east;

    @ApiModelProperty(value = "西北部")
    private Integer  northWest;

    @ApiModelProperty(value = "南部")
    private Integer  south;

    @ApiModelProperty(value = "北方")
    private Integer  north;







}
