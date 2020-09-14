package com.cp.dd.web.form.zs;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 认证师资
 *
 * @author chengp
 * @date 2019/9/20
 */
@Data
public class ZsTeachersForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "名字不能为空")
    @ApiModelProperty(value = "名字", required = true)
    private String name;

    @NotBlank(message = "性别不能为空")
    @ApiModelProperty(value = "性别（男/女）", required = true)
    private String sex;

    @NotBlank(message = "学类型不能为空")
    @ApiModelProperty(value = "教学类型(青训/幼儿)", required = true)
    private String type;

    @NotBlank(message = "职务不能为空")
    @ApiModelProperty(value = "职务", required = true)
    private String job;

    @NotBlank(message = "教龄不能为空")
    @ApiModelProperty(value = "教龄", required = true)
    private String teachingYears;

    @NotBlank(message = "身高不能为空")
    @ApiModelProperty(value = "身高", required = true)
    private Double height;

    @NotBlank(message = "体重不能为空")
    @ApiModelProperty(value = "体重", required = true)
    private Double weight;

    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号", required = true)
    private String mobile;

    @NotBlank(message = "身份证不能为空")
    @ApiModelProperty(value = "身份证", required = true)
    private String idCard;

    @NotBlank(message = "所属单位不能为空")
    @ApiModelProperty(value = "所属单位", required = true)
    private String dept;

}
