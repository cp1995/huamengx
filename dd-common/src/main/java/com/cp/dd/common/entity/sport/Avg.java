package com.cp.dd.common.entity.sport;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 场次信息
 * </p>
 *
 * @author CodeGenerator
 * @date 2019-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "avg对象", description = "会员信息")
public class Avg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "年龄")
    private String age;

    @ApiModelProperty(value = "小孩性别  1男 2女")
    private Integer sex;

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
