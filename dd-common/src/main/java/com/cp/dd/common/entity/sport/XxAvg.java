package com.cp.dd.common.entity.sport;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "XxAvg对象", description = "")
public class XxAvg implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer sex;

    @ApiModelProperty(value = "身高平均值")
    private Double heightAvg;

    private String age;

    @ApiModelProperty(value = "bmi平均值")
    private Double ibmAvg;

    @ApiModelProperty(value = "肺活量平均值")
    private Integer feiHlAvg;

    @ApiModelProperty(value = "跳绳平均值")
    private Integer tiaosAvg;

    @ApiModelProperty(value = "柔韧性平均值")
    private Double flexibilityAvg;

    @ApiModelProperty(value = "灵敏性平均值")
    private Double sensitiveAvg;

    @ApiModelProperty(value = "移动平均值")
    private Double removeAvg;

    @ApiModelProperty(value = "传球平均值")
    private Integer passAvg;

    @ApiModelProperty(value = "投篮平均值")
    private Integer shootAvg;


}
