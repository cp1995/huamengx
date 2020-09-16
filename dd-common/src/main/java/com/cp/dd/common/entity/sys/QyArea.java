package com.cp.dd.common.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 区域设置
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "QyArea对象", description = "区域设置")
public class QyArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "行政区划编码")
    private String code;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "省code")
    private String provinceCode;

    @ApiModelProperty(value = "区域名称")
    private String name;

    @ApiModelProperty(value = "创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty(value = "创建时间/提交时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
