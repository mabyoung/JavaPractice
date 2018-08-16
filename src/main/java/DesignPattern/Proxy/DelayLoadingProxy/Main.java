package DesignPattern.Proxy.DelayLoadingProxy;

public class Main {
    public static void main(String[] args) {
        DBQueryProxy dbQueryProxy = new DBQueryProxy();
        System.out.println(dbQueryProxy.request());
    }
}
