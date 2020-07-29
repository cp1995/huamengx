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
public class ItemCountVO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "男总数")
    private Integer nanTotal;

    @ApiModelProperty(value = "女总数")
    private Integer nvTotal;

    @ApiModelProperty(value = "男身高合格数")
    private Integer nanHeightHg;

    @ApiModelProperty(value = "女身高合格数")
    private Integer nvHeightHg;

    @ApiModelProperty(value = "男上肢合格数")
    private Integer nanLimbHg;

    @ApiModelProperty(value = "女上肢合格数")
    private Integer nvLimbHg;

    @ApiModelProperty(value = "男下肢合格数")
    private Integer nanLegsHg;

    @ApiModelProperty(value = "女下肢合格数")
    private Integer nvLegsHg;

    @ApiModelProperty(value = "男协调性合格数")
    private Integer nanCoordinateHg;

    @ApiModelProperty(value = "女协调性合格数")
    private Integer nvCoordinateHg;

    @ApiModelProperty(value = "男平衡性合格数")
    private Integer nanBalanceHg;

    @ApiModelProperty(value = "女平衡性合格数")
    private Integer nvBalanceHg;

    @ApiModelProperty(value = "男柔韧性合格数")
    private Integer nanFlexibilityHg;

    @ApiModelProperty(value = "女柔韧性合格数")
    private Integer nvFlexibilityHg;

    @ApiModelProperty(value = "男灵敏性合格数")
    private Integer nanSensitivesHg;

    @ApiModelProperty(value = "女灵敏性合格数")
    private Integer nvSensitivesHg;

    @ApiModelProperty(value = "男IBM合格数")
    private Integer nanIbmHg;

    @ApiModelProperty(value = "女IBM合格数")
    private Integer nvIbmHg;






}
