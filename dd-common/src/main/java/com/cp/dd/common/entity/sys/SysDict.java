package com.cp.dd.common.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysDict对象", description = "字典表")
public class SysDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "字典码不为空")
    @ApiModelProperty(value = "字典码")
    private String code;

    @NotBlank(message = "字典值不为空")
    @ApiModelProperty(value = "字典值")
    private String dictKey;

    @ApiModelProperty(value = "字典名称")
    private String dictValue;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "字典备注")
    private String remark;

    @ApiModelProperty(value = "是否已删除")
    private Boolean isDeleted;


}
