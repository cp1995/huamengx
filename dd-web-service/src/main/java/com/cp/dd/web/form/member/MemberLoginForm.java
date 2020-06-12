package com.cp.dd.web.form.member;

import com.cp.dd.common.support.validator.custom.StatusRange;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * jwt登录参数
 *
 * @author chengp
 * @date 2019/9/20
 */
@Data
public class MemberLoginForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "账号/手机不能为空")
    @ApiModelProperty(value = "账号/手机", required = true)
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true)
    private String password;


}
