package com.ldy.common.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 跳过验证token
 */
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface PassToken {
    boolean required() default true;
}
