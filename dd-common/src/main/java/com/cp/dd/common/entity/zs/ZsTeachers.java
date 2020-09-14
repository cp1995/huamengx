package com.cp.dd.common.entity.zs;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @date 2020-09-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ZsTeachers对象", description = "")
public class ZsTeachers implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "教学类型(青训/幼儿)")
    private String type;

    @ApiModelProperty(value = "职务")
    private String job;

    @ApiModelProperty(value = "教龄")
    private String teachingYears;

    @ApiModelProperty(value = "身高")
    private Double height;

    @ApiModelProperty(value = "体重")
    private Double weight;

    @ApiModelProperty(value = "身份证")
    private String idCard;

    @ApiModelProperty(value = "所属单位")
    private String dept;

    @ApiModelProperty(value = "认证时间")
    private LocalDate rzTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDate rzUpdateTime;

    @ApiModelProperty(value = "创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;


}
