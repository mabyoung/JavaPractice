package Basic.ExtendsTest.TestThree;

/**
 * Created by rui on 2018/9/6.
 */
class A {
    public String str = "我是A的属性";
    public void function(){
        System.out.println("我是A的方法");
    }
}
class B extends A{
    public String str = "我是B的属性";
    public void function(){
        System.out.println("我是B的方法");
    }
}
public class Demo {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.str);
        a.function();
    }
}
