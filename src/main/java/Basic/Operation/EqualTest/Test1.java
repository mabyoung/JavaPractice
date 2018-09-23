package Basic.Operation.EqualTest;

/**
 * Created by rui on 2018/9/19.
 */
public class Test1 {
    private static final String s11 = "hello";
    private static final String s22 = "world";
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        String s4 = s11+s22;
        String s5 = s1+"world";
        String s6 = s5.intern();
        String s7 = "hello"+new String ("world");
        System.out.println(s3==s4);
        System.out.println(s3==s5);
        System.out.println(s4==s5);
        System.out.println(s3==s7);
        System.out.println(s4==s7);
        System.out.println(s5==s7);
    }
}
