package com.cp.dd.web.form.zs;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 认证师资
 *
 * @author chengp
 * @date 2019/9/20
 */
@Data
public class ZsPersonalForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "教师名字不能为空")
    @ApiModelProperty(value = "教师名字", required = true)
    private String name;

    @ApiModelProperty(value = "培训名称", required = true)
    private String pxName;

    @ApiModelProperty(value = "证书编号", required = true)
    private String code;

    @ApiModelProperty(value = "证书名称", required = true)
    private String zsName;

    @ApiModelProperty(value = "内容", required = true)
    private String content;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTime;

}
