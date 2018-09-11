package Basic.ClassLoader.Test;


/**
 * Created by rui on 2018/9/11.
 */
class Singleton1{
    private static Singleton1 singleton1 = new Singleton1();
    public static int value1;
    public static int value2 = 0;
    private Singleton1(){
        value1++;
        value2++;
    }
    public static Singleton1 getInstance(){
        return singleton1;
    }
}
class Singleton2{
    public static int value1;
    public static int value2 = 0;
    private static Singleton2 singleton2 = new Singleton2();
    private Singleton2(){
        value1++;
        value2++;
    }
    public static Singleton2 getInstance(){
        return singleton2;
    }
}
public class Main {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println(singleton1.value1+"_"+singleton1.value2);
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2.value1+"_"+singleton2.value2);
    }
}
