package ru.itsjava;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBTestApp {
    public static void main(String[] args) {
        new SampleChild().method1();

        System.out.println("//------------------------------------------//");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleParent.class);
        enhancer.setCallback(new MethodInterceptor() {

            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                if (method.getName().contains("method2")) {
                    System.out.println("SampleProxy.method2");
                    return null;
                }else {
                    return proxy.invokeSuper(obj, args);
                }
            }
        });
        ((SampleParent) enhancer.create()).method1();
    }
}
