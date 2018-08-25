package DesignPattern.Proxy.DynamicProxy.ExampleOfJDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //要代理的真实对象
        Subject realSubject = new RealSubject();
        //真实对象绑定的处理器
        InvocationHandler handler = new DynamicProxy(realSubject);
        //通过代理动态生成对象
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.hello("world");
    }
}
