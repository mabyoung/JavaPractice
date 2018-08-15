package DesignPattern.Singleton.SluggardType.SychronizedVersion;

/**
 * 懒汉模式(双重校验锁)
 */
public class Singleton {
    private static volatile Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                singleton = new Singleton();
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);
    }
}
