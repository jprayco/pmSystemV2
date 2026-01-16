package com.pms.pmSystem.config.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auditable {

    String message() default "";

    String auditAction() default "";

    String actor() default "";

    String device() default "";

    String ipAddress() default "";

    String os() default "";

    String browser() default "";
}
