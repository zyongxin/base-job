package com.bhzy.carnet.core.annotation;

import java.lang.annotation.*;

/**
 * 权限认证
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
//    String name() default "";
}
