package com.cp.dd.web.form.sport;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * jwt登录参数
 *
 * @author chengp
 * @date 2019/9/20
 */
@Data
public class ItemForm implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "场次id")
    @NotNull(message = "场次id不能为空")
    private Long sportId;

    @ApiModelProperty(value = "小孩姓名", required = true)
    @NotNull(message = "小孩姓名不能为空")
    private String name;

    @ApiModelProperty(value = "小孩性别  1男 2女",required = true)
    @NotNull(message = "小孩性别不能为空")
    private Integer sex;

    @ApiModelProperty(value = "出生年月yyyy-MM-dd", required = true)
  //  @DateTimeFormat(pattern = "yyyy-MM")
    @NotNull(message = "出生年月日不能为空")
    private String birth;

    @ApiModelProperty(value = "家长姓名")
    private String parentName;

    @Pattern(regexp = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$", message = "手机格式错误")
    @ApiModelProperty(value = "手机号")
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

    @ApiModelProperty(value = "拍球", required = false)
    private Integer racket;

    @ApiModelProperty(value = "传球", required = false)
    private Integer pass;

    @ApiModelProperty(value = "投篮", required = false)
    private Integer shoot;

    @ApiModelProperty(value = "华蒙星学员/非学员", required = true)
    @NotBlank(message = "学员类型不能为空")
    private String xyType;

}
