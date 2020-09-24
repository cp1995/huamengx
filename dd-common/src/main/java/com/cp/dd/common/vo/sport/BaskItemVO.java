package com.cp.dd.common.vo.sport;

import com.cp.dd.common.entity.sport.BaskItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "系统用户信息")
public class BaskItemVO extends BaskItem implements Serializable {



    @ApiModelProperty(value = "场次名")
    private String sportName;

    @ApiModelProperty(value = "全国平均成绩身高")
    private double hightAvg;

    @ApiModelProperty(value = "全国平均成绩BMI")
    private double bmiAvg;





}
