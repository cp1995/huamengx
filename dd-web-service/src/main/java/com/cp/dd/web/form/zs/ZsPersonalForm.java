package com.cp.dd.web.form.zs;

import com.cp.dd.common.support.validator.custom.Mobile;
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

    @ApiModelProperty(value = "培训名称")
    private String pxName;

    @ApiModelProperty(value = "证书编号", required = true)
    private String code;

    @ApiModelProperty(value = "证书名称", required = true)
    private String zsName;

    @ApiModelProperty(value = "1男 2女", required = true)
    private Integer sex;

    @NotBlank(message = "身份证不为空")
    @ApiModelProperty(value = "身份证", required = true)
    private String idCard;

    @NotBlank(message = "手机号不为空")
    @Mobile
    @ApiModelProperty(value = "手机号", required = true)
    private String mobile;

    @ApiModelProperty(value = "期数")
    private String periodical;

    @ApiModelProperty(value = "区域编码")
    private String areaCode;

    @ApiModelProperty(value = "所属机构")
    private String deptName;

    @ApiModelProperty(value = "内容")
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
