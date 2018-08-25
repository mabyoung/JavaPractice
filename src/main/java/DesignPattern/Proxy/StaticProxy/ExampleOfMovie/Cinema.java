package DesignPattern.Proxy.StaticProxy.ExampleOfMovie;

/**
 * 代理模式可以在不修改被代理对象源码的基础上，通过扩展代理类，进行一些功能的附加与增强（AOP）。
 * 值得注意的是，代理类和被代理类应该共同实现一个接口，或者是共同继承某个类。
 * 静态代理的类型是事先预定好的，需要手动编写代码让 Cinema 实现 Movie 接口。
 * 而在动态代理中，我们可以让程序在运行的时候自动在内存中创建一个实现 Movie 接口的代理，而不需要去定义 Cinema 这个类。
 * https://blog.csdn.net/briblue/article/details/73928350
 */
public class Cinema implements Movie{
    RealMovie realMovie;
    public Cinema(RealMovie realMovie){
        this.realMovie = realMovie;
    }

    @Override
    public void play() {
        System.out.println("电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
        realMovie.play();
        System.out.println("电影结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
    }
}
