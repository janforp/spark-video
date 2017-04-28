package com.janita.video.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Janita on 2017-04-28 23:47
 */
public class ProxyUtil {

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(final int discountCoupon,final Class<?> interfaceClass,final Class<?> implementsClass){

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Integer returnValue = (Integer)method.invoke(implementsClass.newInstance(),args);

                return returnValue - discountCoupon;
            }
        });

    }
}
