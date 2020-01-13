package com.example.designPattern.proxy.intercept;

import java.lang.reflect.Method;

public interface Interceptor {

    boolean before(Object proxy, Object target, Method method, Object[] args);

    void around(Object proxy, Object target, Method method, Object[] args);

    void after(Object proxy, Object target, Method method, Object[] args);
}