package com.huxp.core.annotation;

import java.lang.annotation.*;

/**
 * @Author: Huxp
 * @Since: 2018/8/27 下午3:23
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Json {

    Class<?> type();

    String include() default "";

    String filter() default "";
}
