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
public class ZsDeptForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "加盟商名称不能为空")
    @ApiModelProperty(value = "加盟商名称", required = true)
    private String name;

    @ApiModelProperty(value = "法人姓名")
    private String frName;

    @NotBlank(message = "法人身份证不能为空")
    @ApiModelProperty(value = "法人身份证", required = true)
    private String idCard;

    @ApiModelProperty(value = "加盟商税号")
    private String shCode;

    @ApiModelProperty(value = "加盟商地址")
    private String address;

    @NotBlank(message = "对接销售不能为空")
    @ApiModelProperty(value = "对接销售", required = true)
    private String djxs;

    @NotNull(message = "加盟类型不能为空")
    @ApiModelProperty(value = "加盟类型(部门分类)", required = true)
    private Long categoryId;

    @ApiModelProperty(value = "所属子公司")
    private String company;

    @NotNull(message = "区域编码不能为空")
    @ApiModelProperty(value = "区域编码")
    private String areaCode;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "合同编号")
    private String htNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "合同开始时间")
    private LocalDate htStartTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "合同结束时间")
    private LocalDate htEndTime;

    @ApiModelProperty(value = "加盟金额")
    private String amount;

    @ApiModelProperty(value = "合同归档(未归档/已归档)")
    private String htgd;

    @ApiModelProperty(value = "联系人姓名")
    private String lxrName;

    @ApiModelProperty(value = "联系人性别")
    private String lxrSex;

    @NotBlank(message = "手机号不为空")
    @Mobile
    @ApiModelProperty(value = "联系人电话", required = true)
    private String lxrMobile;

    @ApiModelProperty(value = "联系人职务")
    private String lxrPost;

    @ApiModelProperty(value = "联系人邮箱")
    private String lxrEmail;

    @ApiModelProperty(value = "收货人姓名")
    private String shrName;

    @ApiModelProperty(value = "收货人电话")
    private String shrMobile;

    @ApiModelProperty(value = "收货人地址")
    private String shrAddress;

    @ApiModelProperty(value = "邮政编码")
    private String shrCode;

}
