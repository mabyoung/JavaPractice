package Basic.Thread.ThreadLocalTest.InitialValueTest;

public class Main {
    private static ThreadLocalExt t1 = new ThreadLocalExt();

    public static class ThreadLocalExt extends ThreadLocal{
        protected Object initialValue(){
            return "我是默认值 第一次get不再为null";
        }
    }

    public static void main(String[] args) {
        if (t1.get() == null) {
            System.out.println("从未放过值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
