package com.bhzy.carnet.core.annotation;

import java.lang.annotation.*;

/**
 * 仅用来做日志记录的注解
 * 在需要记录的方法上添加此注解
 * @author pc
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogger {
	String value() default "";
	String name() default "";
}
