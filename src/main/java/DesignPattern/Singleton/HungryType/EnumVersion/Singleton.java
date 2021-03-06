package DesignPattern.Singleton.HungryType.EnumVersion;

/**
 *  枚举实现线程安全的单例模式:
 *  特点：无偿地提供了序列化机制，并由JVM从根本上提供保障，绝对防止多次实例化，是更简洁、高效、安全的实现单例的方式。
 */
public class Singleton{
    private Singleton(){}
    private enum SingletonEnum{
        INSTANCE;
        static {
            System.out.println("加载内部类");
        }
        private Singleton instance = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonEnum.INSTANCE.instance;
    }
    public void say(){
        System.out.println("dd");
    }
}
class test{
    public static void main(String[] args) throws Exception{
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        singleton1.say();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);
    }
}
