package com.nuckyboe.kotlin_jetpack_exoplayer.IOC;

import android.content.Context;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class ListenerInvocationHandler implements InvocationHandler {
    private Context context;
    private HashMap<String, Method> callbacks;

    public ListenerInvocationHandler(Context context, HashMap<String, Method> callbacks) {
        this.context = context;
        this.callbacks = callbacks;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        String name = method.getName();
        if (callbacks.containsKey(name)) {
            result = callbacks.get(name).invoke(context, args);
        } else {
            result = method.invoke(proxy, args);
        }
        return result;
    }
}
