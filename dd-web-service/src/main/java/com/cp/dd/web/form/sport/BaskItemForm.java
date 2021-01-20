package com.cp.dd.web.form.sport;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
public class BaskItemForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "场次id")
    @NotNull(message = "场次id不能为空")
    private Long sportId;

    @ApiModelProperty(value = "小孩姓名", required = true)
    @NotBlank(message = "小孩姓名不能为空")
    private String name;

    @ApiModelProperty(value = "小孩性别  1男 2女",required = true)
    @NotNull(message = "小孩性别不能为空")
    private Integer sex;

    @ApiModelProperty(value = "班级  1小班 2中班 3大班")
    @NotNull(message = "班级不能为空")
    private Integer type;

    @ApiModelProperty(value = "出生年月yyyy-MM-dd", required = true)
    @DateTimeFormat(pattern = "yyyy-MM")
    @NotBlank(message = "出生年月日不能为空")
    private String birth;

    @ApiModelProperty(value = "身高", required = true)
    private double height;

    @ApiModelProperty(value = "体重" , required = true)
    private double weight;

    @ApiModelProperty(value = "家长姓名")
    private String parentName;

    @ApiModelProperty(value = "手机号")
    @Pattern(regexp = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$", message = "手机格式错误")
   // @NotBlank(message = "手机号姓名不能为空")
    private String phone;

    @ApiModelProperty(value = "学校", required = true)
    @NotBlank(message = "学校姓名不能为空")
    private String school;

    @NotNull(message = "滚球不能为空")
    @ApiModelProperty(value = "滚球", required = true)
    private Integer rall;

    @NotNull(message = "运球不能为空")
    @ApiModelProperty(value = "运球", required = true)
    private Integer dsDribble;

    @NotNull(message = "拍球不能为空")
    @ApiModelProperty(value = "拍球", required = true)
    private Double bat;

    @NotNull(message = "传球不能为空")
    @ApiModelProperty(value = "传球", required = true)
    private Integer pass;

    @NotNull(message = "投篮不能为空")
    @ApiModelProperty(value = "投篮", required = true)
    private Integer shoot;

    @ApiModelProperty(value = "华蒙星学员/非学员", required = true)
    @NotBlank(message = "学员类型不能为空")
    private String xyType;

}
