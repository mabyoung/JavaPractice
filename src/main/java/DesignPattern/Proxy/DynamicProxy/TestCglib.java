package DesignPattern.Proxy.DynamicProxy;

public class TestCglib {
    public static void main(String[] args) {
        BookProxyLib cglib = new BookProxyLib();
        BookProxyImpl bookProxy = (BookProxyImpl)cglib.getInstance(new BookProxyImpl());
        bookProxy.addBook();
    }
}
