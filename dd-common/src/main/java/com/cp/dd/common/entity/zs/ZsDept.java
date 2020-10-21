package com.cp.dd.common.entity.zs;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ZsDept对象", description = "")
public class ZsDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "加盟商名称")
    private String name;

    @ApiModelProperty(value = "法人姓名")
    private String frName;

    @ApiModelProperty(value = "法人身份证")
    private String idCard;

    @ApiModelProperty(value = "加盟商税号")
    private String shCode;

    @ApiModelProperty(value = "加盟商地址")
    private String address;

    @ApiModelProperty(value = "对接销售")
    private String djxs;

    @ApiModelProperty(value = "所属子公司")
    private String company;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "合同编号")
    private String htNumber;

    @ApiModelProperty(value = "加盟类型")
    private Long categoryId;

    @ApiModelProperty(value = "合同开始时间")
    private LocalDate htStartTime;

    @ApiModelProperty(value = "合同结束时间")
    private LocalDate htEndTime;

    @ApiModelProperty(value = "加盟金额")
    private String amount;

    @NotNull(message = "区域编码不能为空")
    @ApiModelProperty(value = "区域编码")
    private String areaCode;

    @ApiModelProperty(value = "shortCode")
    private String shortCode;

    @ApiModelProperty(value = "合同归档(未归档/已归档)")
    private String htgd;

    @ApiModelProperty(value = "联系人姓名")
    private String lxrName;

    @ApiModelProperty(value = "联系人性别")
    private String lxrSex;

    @ApiModelProperty(value = "联系人电话")
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

    @ApiModelProperty(value = "加盟状态 待加盟 加盟中 已过期 已终止")
    private String status;

    @ApiModelProperty(value = "审核状态 0代审核 1审核通过")
    private Integer auditStatus;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;


}
