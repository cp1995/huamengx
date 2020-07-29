package com.cp.dd.common.vo.sport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "小学个项目统计")
public class XxItemCountVO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "男总数")
    private Integer nanTotal;

    @ApiModelProperty(value = "女总数")
    private Integer nvTotal;

    @ApiModelProperty(value = "男身高合格数")
    private Integer nanHeightHg;

    @ApiModelProperty(value = "女身高合格数")
    private Integer nvHeightHg;

    @ApiModelProperty(value = "男IBM合格数")
    private Integer nanIbmHg;

    @ApiModelProperty(value = "女IBM合格数")
    private Integer nvIbmHg;

    @ApiModelProperty(value = "男肺活量合格数")
    private Integer nanFeiHlHg;

    @ApiModelProperty(value = "女肺活量合格数")
    private Integer nvFeiHlHg;

    @ApiModelProperty(value = "男肺跳绳合格数")
    private Integer nanTiaosHg;

    @ApiModelProperty(value = "女肺跳绳合格数")
    private Integer nvTiaosHg;

    @ApiModelProperty(value = "男柔韧性合格数")
    private Integer nanFlexibilityHg;

    @ApiModelProperty(value = "女柔韧性合格数")
    private Integer nvFlexibilityHg;

    @ApiModelProperty(value = "男灵敏性合格数")
    private Integer nanSensitivesHg;

    @ApiModelProperty(value = "女灵敏性合格数")
    private Integer nvSensitivesHg;








}
