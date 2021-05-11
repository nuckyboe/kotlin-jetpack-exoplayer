package com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//元注解
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventBase {

    /**
     * 设置事件源
     */
    String listener();

    /**
     * 事件源类型
     */
    Class<?> listenerType();

    /**
     * 事件源的回调
     */
    String callback();
}
