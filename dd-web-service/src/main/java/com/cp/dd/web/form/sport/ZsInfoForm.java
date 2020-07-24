package com.cp.dd.web.form.sport;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

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

    @ApiModelProperty(value = "证书名字")
    @NotBlank(message = "证书名字不能为空")
    private String name;

    @ApiModelProperty(value = "证书编号")
    @NotBlank(message = "证书编号不能为空")
    private String code;

    private String icon;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "机构证书、个人证书  ")
    private String categoryType;

    @ApiModelProperty(value = "区域编码")
    @NotBlank(message = "区域编码不能为空")
    private String areaCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "证书失效时间")
    @NotNull(message = "证书失效不能为空")
    private LocalDateTime sxTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "证书开始时间不能为空")
    @ApiModelProperty(value = "证书开始时间")
    private LocalDateTime stTime;

    @ApiModelProperty(value = "分类id")
    @NotNull(message = "分类id不能为空")
    private Long categoryId;



}
