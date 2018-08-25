package DesignPattern.Proxy.DynamicProxy.ExampleOfCGLIB;

import DesignPattern.Proxy.DelayLoadingProxy.DBQuery;
import DesignPattern.Proxy.DelayLoadingProxy.IDBQuery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DBQueryHandler implements InvocationHandler {
    private IDBQuery realQuery = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (realQuery == null){
            realQuery = new DBQuery();
        }
        return realQuery.request();
    }

    public static IDBQuery createProxy(){
        IDBQuery proxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IDBQuery.class}, new DBQueryHandler());
        return proxy;
    }
}
