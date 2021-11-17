package com.cp.dd.common.support.validator.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 手机号码验证
 *
 * @author chengp
 * @date 2019/10/17
 */
@Documented
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Constraint(validatedBy = {MobileValidator.class})
@Retention(RUNTIME)
public @interface Mobile {

    /**
     * 描述
     */
    String message() default "手机格式不正确";

    String pattern() default "^[1](([3|5|7|8|9][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
