package DesignPattern.Singleton.HungryType.BasicVersion;

/**
 * 饿汉方式(线程安全）
 * 特点：可以通过反射机制攻击；线程安全[多个类加载器除外]。
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);
    }
}
