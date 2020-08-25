package com.cp.dd.common.entity.sport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ZsInfo对象", description = "")
public class ZsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "单位名称/ 机构名称")
    private String deptName;

    @ApiModelProperty(value = "证书编号/合同号")
    private String code;

    @ApiModelProperty(value = "照片")
    private String icon;

    @ApiModelProperty(value = "性别 1男2女")
    private Integer sex;

    @ApiModelProperty(value = "身份证")
    private String idCard;

    @ApiModelProperty(value = "证书路径")
    private String path;

    @ApiModelProperty(value = "研修班")
    private String grade;

    @ApiModelProperty(value = "区域编码")
    private Long areaId;

    @ApiModelProperty(value = "机构证书、个人证书  ")
    private String categoryType;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "证书有效期失效时间")
    private LocalDate sxTime;

    @ApiModelProperty(value = "证书有效期开始时间")
    private LocalDate stTime;

    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "1正常  -1删除")
    private Integer status;

    @ApiModelProperty(value = "审核状态  0审核 1审核通过")
    private Integer AuditStatus;


}
