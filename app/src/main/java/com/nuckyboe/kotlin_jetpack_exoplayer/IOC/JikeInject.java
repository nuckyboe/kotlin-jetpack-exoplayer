package com.nuckyboe.kotlin_jetpack_exoplayer.IOC;

import android.content.Context;
import android.view.View;

import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.ContentView;
import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.ViewInject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JikeInject {
    public static void bind(Context context) {
        injectLayout(context);
        injectView(context);
    }

    private static void injectView(Context context) {
        Class<? extends Context> aClass = context.getClass();
        try {
            Method findViewById = aClass.getMethod("findViewById", int.class);
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField:declaredFields) {
                ViewInject viewInject = declaredField.getAnnotation(ViewInject.class);
                if (viewInject == null) {
                    return;
                }
                int id = viewInject.value();
                View view = (View) findViewById.invoke(context, id);
                declaredField.setAccessible(true);
                declaredField.set(context, view);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void injectLayout(Context context) {
        Class<? extends Context> aClass = context.getClass();
        try {
            ContentView contentView = aClass.getAnnotation(ContentView.class);
            if (contentView == null) {
                return;
            }
            int layoutId = contentView.value();
            Method method = aClass.getMethod("setContentView", int.class);
            method.invoke(context, layoutId);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
