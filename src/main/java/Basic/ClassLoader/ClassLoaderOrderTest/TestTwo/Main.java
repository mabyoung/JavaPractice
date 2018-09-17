package Basic.ClassLoader.ClassLoaderOrderTest.TestTwo;

/**
 * Created by rui on 2018/9/12.
 */
class SuperClass{
    static {
        System.out.println("父类初始化");
    }
    public static int value = 66;
}
class Subclass extends SuperClass{
    static {
        System.out.println("子类初始化");
    }
}
public class Main {
}
