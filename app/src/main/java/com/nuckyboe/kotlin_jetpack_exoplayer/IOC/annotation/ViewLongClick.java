package com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@EventBase(listener = "setOnLongClickListener",listenerType = View.OnLongClickListener.class, callback = "onLongClick")
public @interface ViewLongClick {
    int[] value();
}
