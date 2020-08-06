package com.cp.dd.common.vo.sport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "各类证书总数统计")
public class ZsInfoCountVO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "总数")
    private Integer total;

    @ApiModelProperty(value = "分类名称")
    private String  categoryName;







}
