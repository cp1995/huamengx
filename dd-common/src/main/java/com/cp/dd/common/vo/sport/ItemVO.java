package com.cp.dd.common.vo.sport;

import com.cp.dd.common.entity.sport.Item;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "系统用户信息")
public class ItemVO extends  Item  implements Serializable {



    @ApiModelProperty(value = "场次名")
    private String sportName;

    @ApiModelProperty(value = "全国平均成绩身高")
    private double hightAvg;


    @ApiModelProperty(value = "全国平均成绩下肢")
    private double legsAvg;

    @ApiModelProperty(value = "全国平均成绩协调性")
    private double coordinateAvg;

    @ApiModelProperty(value = "全国平均成绩平衡性")
    private double balanceAvg;

    @ApiModelProperty(value = "全国平均成绩柔韧性")
    private double flexibilityAvg;

    @ApiModelProperty(value = "全国平均成绩灵敏性")
    private double sensitiveAvg;

    @ApiModelProperty(value = "全国平均成绩上肢")
    private double limbAvg;

    @ApiModelProperty(value = "全国平均成绩拍球")
    private int racketAvg;

    @ApiModelProperty(value = "全国平均成绩传球")
    private int passAvg;

    @ApiModelProperty(value = "全国平均成绩投篮")
    private int shootAvg;

    @ApiModelProperty(value = "全国平均成绩BMI")
    private double bmiAvg;


}
