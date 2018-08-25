package DesignPattern.Proxy.DynamicProxy.ExampleOfCounter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * AOP机制是 Spring 所提供的核心功能之一，其既是Java动态代理机制的经典应用，也是动态AOP实现的代表。
 * Spring AOP默认使用Java动态代理来创建AOP代理，具体通过以下几个步骤来完成：
 * 1.Spring IOC 容器创建Bean(目标类对象)
 * 2.Bean创建完成后，Bean后处理器(BeanPostProcessor)根据具体的切面逻辑及Bean本身使用Java动态代理技术生成代理对象
 * 3.应用程序使用上述生成的代理对象替代原对象来完成业务逻辑，从而达到增强处理的目的
 */
public class Counter implements InvocationHandler {
    private Object object;
    public Counter(Object object){
        this.object  = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始，柜台是："+this.getClass().getSimpleName());
        method.invoke(object, args);
        System.out.println("销售结束");
        return null;
    }
}
