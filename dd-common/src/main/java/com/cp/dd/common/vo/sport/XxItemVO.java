package com.cp.dd.common.vo.sport;

import com.cp.dd.common.entity.sport.Item;
import com.cp.dd.common.entity.sport.XxItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "系统用户信息")
public class XxItemVO extends XxItem implements Serializable {



    @ApiModelProperty(value = "场次名")
    private String sportName;

    @ApiModelProperty(value = "全国平均成绩身高")
    private double hightAvg;

    @ApiModelProperty(value = "全国平均成绩肺活量")
    private Integer feiHlAvg;

    @ApiModelProperty(value = "全国平均成绩跳绳")
    private Integer tiaosAvg;

    @ApiModelProperty(value = "全国平均成绩柔韧性")
    private double flexibilityAvg;

    @ApiModelProperty(value = "全国平均成绩灵敏性")
    private double sensitiveAvg;

    @ApiModelProperty(value = "全国平均成绩移动")
    private double removeAvg;

    @ApiModelProperty(value = "全国平均成绩接球")
    private int passAvg;

    @ApiModelProperty(value = "全国平均成绩投篮")
    private int shootAvg;

    @ApiModelProperty(value = "全国平均成绩BMI")
    private double bmiAvg;


}
