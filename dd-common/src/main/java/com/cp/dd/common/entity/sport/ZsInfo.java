package com.cp.dd.common.entity.sport;

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

    @ApiModelProperty(value = "证书名字")
    private String name;

    @ApiModelProperty(value = "证书编号")
    private String code;

    private String icon;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "区域编码")
    private String areaCode;

    private String shortCode;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "证书失效时间")
    private LocalDateTime sxTime;

    @ApiModelProperty(value = "证书开始时间")
    private LocalDateTime stTime;

    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "1正常  -1删除")
    private Integer status;


}
