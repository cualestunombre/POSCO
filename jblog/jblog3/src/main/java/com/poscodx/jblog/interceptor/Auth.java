package com.poscodx.jblog.interceptor;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(value = { TYPE,METHOD })
public @interface Auth {
	public String role() default "USER";
}
