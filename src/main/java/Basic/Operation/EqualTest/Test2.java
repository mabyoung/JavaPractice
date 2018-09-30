package Basic.Operation.EqualTest;

/**
 * int == Integer，Integer是int的封装类，当Integer与int进行==比较时，Integer就会拆箱成一个int类型。
 * 所以还是相当于两个int类型进行比较，这里的Integer,不管是直接赋值，还是new创建的对象，只要跟int比较就会拆箱为int类型，所以就是相等的。
 */
public class Test2 {
    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);
        a = -129;
        b = -129;
        System.out.println(a == b);
        a = 127;
        b = 127;
        System.out.println(a == b);
        a = -128;
        b = -128;
        System.out.println(a == b);
        Integer c = new Integer(-128);
        int d = -128;
        System.out.println(b == c);
        System.out.println(d == c);
    }
}
