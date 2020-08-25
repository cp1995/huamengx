package com.cp.dd.web.form.sport;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
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
public class ZsInfoForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改时使用")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "单位名称/ 机构名称")
    private String deptName;

    @ApiModelProperty(value = "证书编号/授权合同号")
    @NotBlank(message = "证书编号不能为空")
    private String code;

    @ApiModelProperty(value = "照片")
    private String icon;

    @ApiModelProperty(value = "身份证")
    private String idCard;

    @ApiModelProperty(value = "性别 1男2女")
    private Integer sex;

    @ApiModelProperty(value = "证书路径")
    private String path;

    @ApiModelProperty(value = "研修班")
    private String grade;

    @NotNull(message = "区域编码不能为空")
    @ApiModelProperty(value = "区域编码")
    private Long areaId;

    @ApiModelProperty(value = "机构证书、个人证书  ")
    @NotBlank(message = "证书类型不能为空")
    private String categoryType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "证书有效期失效时间")
    @NotNull(message = "证书失效不能为空")
    private LocalDate sxTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "证书开始时间不能为空")
    @ApiModelProperty(value = "证书有效期开始时间")
    private LocalDate stTime;

    @ApiModelProperty(value = "分类id")
    @NotNull(message = "分类id不能为空")
    private Long categoryId;



}
