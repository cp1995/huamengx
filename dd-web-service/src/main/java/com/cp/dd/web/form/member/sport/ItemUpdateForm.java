package com.cp.dd.web.form.member.sport;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * jwt登录参数
 *
 * @author chengp
 * @date 2019/9/20
 */
@Data
public class ItemUpdateForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改时使用")
    private Long id;

    @ApiModelProperty(value = "小孩姓名", required = true)
    @NotNull(message = "小孩姓名不能为空")
    private String name;

    @ApiModelProperty(value = "身高", required = true)
    private double height;

    @ApiModelProperty(value = "体重" , required = true)
    private double weight;

    @ApiModelProperty(value = "下肢", required = true)
    private Integer legs;

    @ApiModelProperty(value = "上肢", required = true)
    private double szLimb;

    @ApiModelProperty(value = "协调性", required = true)
    private double coordinate;

    @ApiModelProperty(value = "平衡性", required = true)
    private double balance;

    @ApiModelProperty(value = "柔韧性", required = true)
    private double flexibility;

    @ApiModelProperty(value = "灵敏性", required = true)
    private double sensitives;

    @ApiModelProperty(value = "拍球", required = false)
    private Integer racket;

    @ApiModelProperty(value = "传球", required = false)
    private Integer pass;

    @ApiModelProperty(value = "投篮", required = false)
    private Integer shoot;

}
