package com.nuckyboe.kotlin_jetpack_exoplayer.IOC;

import android.content.Context;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OnClickInvocationHandler implements InvocationHandler {
    private Context context;
    private Method callback;

    public OnClickInvocationHandler(Context context, Method callback) {
        this.context = context;
        this.callback = callback;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        if (method.getName().equals("onClick")) {
            result = callback.invoke(context, args);
        } else {
            result = method.invoke(proxy, args);
        }
        return result;
    }
}
