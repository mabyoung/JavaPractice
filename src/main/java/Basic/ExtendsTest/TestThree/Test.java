package Basic.ExtendsTest.TestThree;

public class Test {
    public static void main(String[] args) throws Exception{
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.loadClass("Basic.ExtendsTest.TestThree.Test2");
        System.out.println("test");
        clazz.forName("Basic.ExtendsTest.TestThree.Test2");
    }
}
class Test2{
    static{
        System.out.println("ok");
    }
}
