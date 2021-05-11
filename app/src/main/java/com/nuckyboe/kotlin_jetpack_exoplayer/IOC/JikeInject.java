package com.nuckyboe.kotlin_jetpack_exoplayer.IOC;

import android.content.Context;
import android.view.View;

import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.ContentView;
import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.EventBase;
import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.ViewInject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class JikeInject {
    public static void bind(Context context) {
        injectLayout(context);
        injectView(context);
        injectEvent(context);
    }

    private static void injectEvent(Context context) {
        Class<? extends Context> aClass = context.getClass();
        try {
            Method findViewById = aClass.getMethod("findViewById", int.class);
            //获取activity里所有方法
            Method[] declaredMethods = aClass.getDeclaredMethods();
            //遍历activity里所有方法
            for (Method declaredMethod : declaredMethods) {
                //获取方法上所有注解
                Annotation[] annotations = declaredMethod.getAnnotations();
                HashMap<String, Method> callbacks = new HashMap<>();
                //遍历方法上所有注解
                for (Annotation annotation : annotations) {
                    //获取注解的注解
                    EventBase eventBase = annotation.annotationType().getAnnotation(EventBase.class);
                    if (eventBase == null) {
                        return;
                    }
                    callbacks.put(eventBase.callback(),declaredMethod);
                    Method value = annotation.annotationType().getMethod("value");
                    int[] ids = (int[]) value.invoke(annotation);

                    for (int id : ids) {
                        View view = (View) findViewById.invoke(context, id);
                        //使用时间三要素：事件、监听、回调
                        Method listener = view.getClass().getMethod(eventBase.listener(), eventBase.listenerType());
                        ListenerInvocationHandler onClickInvocationHandler = new ListenerInvocationHandler(context, callbacks);
                        Object o = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{eventBase.listenerType()}, onClickInvocationHandler);
                        listener.invoke(view, o);
                    }
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void injectView(Context context) {
        Class<? extends Context> aClass = context.getClass();
        try {
            Method findViewById = aClass.getMethod("findViewById", int.class);
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
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
