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
public class MemberForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改时使用")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    
    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "1管理员2录入员3园区管理员4 师资部 5总部管理员 ")
    private Integer role;
    
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "园区id")
    private Long areaId;


}
