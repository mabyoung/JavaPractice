package DesignPattern.Singleton.SluggardType.StaticInnerClassVersion;

/**
 * 懒汉式（登记式/静态内部类方式）
 * 特点：既能实现延迟加载，又能实现线程安全
 */
public class Singleton {
    private static class SingletonHolder{
        static {
            System.out.println("只有当内部类被访问时才会被加载，所以我是懒汉式单例");
        }
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){}
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
//        Singleton singleton1 = Singleton.getInstance();
//        Singleton singleton2 = Singleton.getInstance();
//        System.out.println(singleton1);
//        System.out.println(singleton2);
//        System.out.println(singleton1 == singleton2);
    }
}
