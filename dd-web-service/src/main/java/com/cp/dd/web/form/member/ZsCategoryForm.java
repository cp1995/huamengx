package com.cp.dd.web.form.member;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * jwt登录参数
 *
 * @author chengp
 * @date 2019/9/20
 */
@Data
public class ZsCategoryForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改时使用")
    private Long id;

    @NotBlank(message = "证书类型名称")
    @ApiModelProperty(value = "证书类型名称" , required = true)
    private String name;

    @NotBlank(message = "分类不能为空")
    @ApiModelProperty(value = "读取字典 zs  (机构证书、个人证书)" , required = true)
    private String type;



}
