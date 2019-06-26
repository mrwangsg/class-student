package com.sgwang.aop.annotation;

import java.lang.annotation.*;

/**
 * @创建人 sgwang
 * @name LogAnnotation
 * @user 91119
 * @创建时间 2019/6/26
 * @描述 @LogAnnotation(detail = "通过手机号[{{tel}}]获取用户名", level = 3)
 */
@Documented
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface LogAnnotation {

    /**
     * 方法描述,可使用占位符获取参数:{{tel}}
     */
    String detail() default "";

    /**
     * 日志等级:自己定，此处分为1-9
     */
    int level() default 0;

}
