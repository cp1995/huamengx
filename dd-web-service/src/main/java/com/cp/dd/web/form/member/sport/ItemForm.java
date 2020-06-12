package com.cp.dd.web.form.member.sport;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * jwt登录参数
 *
 * @author chengp
 * @date 2019/9/20
 */
@Data
public class ItemForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改时使用")
    private Long id;

    @ApiModelProperty(value = "场次id")
    @NotNull(message = "场次id不能为空")
    private Long sportId;

    @ApiModelProperty(value = "小孩姓名", required = true)
    @NotNull(message = "小孩姓名不能为空")
    private String name;

    @ApiModelProperty(value = "小孩性别  1男 2女",required = true)
    @NotNull(message = "小孩性别不能为空")
    private Integer sex;

    @ApiModelProperty(value = "出生年月yyyy-MM", required = true)
  //  @DateTimeFormat(pattern = "yyyy-MM")
    @NotNull(message = "出生年月不能为空")
    private String birth;

    @ApiModelProperty(value = "家长姓名", required = true)
    @NotNull(message = "家长姓名不能为空")
    private String parentName;

    @ApiModelProperty(value = "手机号", required = true)
    @NotNull(message = "手机号姓名不能为空")
    private String phone;

    @ApiModelProperty(value = "学校", required = true)
    @NotNull(message = "学校姓名不能为空")
    private String school;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "身高", required = true)
    private double height;

    @ApiModelProperty(value = "体重" , required = true)
    private double weight;

    @ApiModelProperty(value = "父亲身高", required = true)
    private double fHeight;

    @ApiModelProperty(value = "母亲身高", required = true)
    private double mHeight;

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

    @ApiModelProperty(value = "拍球", required = true)
    private Integer racket;

    @ApiModelProperty(value = "传球", required = true)
    private Integer pass;

    @ApiModelProperty(value = "投篮", required = true)
    private Integer shoot;

}
