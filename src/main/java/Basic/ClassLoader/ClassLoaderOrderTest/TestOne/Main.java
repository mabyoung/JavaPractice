package Basic.ClassLoader.ClassLoaderOrderTest.TestOne;


/**
 * Singleton输出结果：1 0
 * 原因：1 首先执行main中的Singleton singleton = Singleton.getInstance();
 * 2 类的加载：加载类Singleton
 * 3 类的验证
 * 4 类的准备：为静态变量分配内存，设置默认值。这里为singleton(引用类型)设置为null,value1,value2（基本数据类型）设置默认值0
 * 5 类的初始化（按照赋值语句进行修改）：
 * 执行private static Singleton singleton = new Singleton();
 * 执行Singleton的构造器：value1++;value2++; 此时value1，value2均等于1
 * 执行public static int value1;
 * public static int value2 = 0;
 * 此时value1=1，value2=0
 *
 * Singleton2输出结果：1 1
 * 原因：1 首先执行main中的Singleton2 singleton2 = Singleton2.getInstance2();
 * 2 类的加载：加载类Singleton2
 * 3 类的验证
 * 4 类的准备：为静态变量分配内存，设置默认值。这里为value1,value2（基本数据类型）设置默认值0,singleton2(引用类型)设置为null
 * 5 类的初始化（按照赋值语句进行修改）：
 * 执行public static int value2 = 0;此时value2=0(value1不变，依然是0);
 * 执行private static Singleton singleton = new Singleton();
 * 执行Singleton2的构造器：value1++;value2++;此时value1，value2均等于1,即为最后结果
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
