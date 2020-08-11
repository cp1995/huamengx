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
public class ZsInfoLsCountVO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "年新增")
    private Integer addInfo;

    @ApiModelProperty(value = "年流失")
    private Integer  reduceInfo;









}
