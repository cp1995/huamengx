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
@ApiModel(value = "ZsPersonal对象", description = "")
public class ZsPersonal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "教师名字")
    private String name;

    @ApiModelProperty(value = "培训名称")
    private String pxName;

    @ApiModelProperty(value = "证书编号")
    private String code;

    @ApiModelProperty(value = "证书名称")
    private String zsName;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "0待失效 1生效 2失效")
    private Integer status;

    @ApiModelProperty(value = "授权开始时间")
    private LocalDate startTime;

    @ApiModelProperty(value = "授权结束时间")
    private LocalDate endTime;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;


}
