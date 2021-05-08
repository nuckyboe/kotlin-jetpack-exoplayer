package com.nuckyboe.kotlin_jetpack_exoplayer.IOC;

import android.content.Context;
import android.media.browse.MediaBrowser;

import com.nuckyboe.kotlin_jetpack_exoplayer.IOC.annotation.ContentView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JikeInject {
    public static void bind(Context context) {
        injectLayout(context);
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
