package com.ldy.common.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 需要验证token
 */
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface UserLoginToken {
    boolean required() default true;
}
