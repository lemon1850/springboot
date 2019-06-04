package com.example.demo.proxy;

import com.example.demo.service.CalImpl;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class StudyProxy {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/wei/IdeaProjects/springboot/src/main/java/com/example/demo/proxy");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CalImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("开始");
                Object b = methodProxy.invokeSuper(o, objects);
                System.out.println("结束");
                return b;
            }
        });
        CalImpl cal = (CalImpl)enhancer.create();
        cal.add(1,2);
    }
}
