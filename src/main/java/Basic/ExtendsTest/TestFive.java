package Basic.ExtendsTest;
class A{ }
class B extends A {}
class C extends A {}
class D extends B {}
public class TestFive {
    public static void main(String[] args) {
        A obj = new D();
        System.out.println(obj instanceof A);
        System.out.println(obj instanceof B);
        System.out.println(obj instanceof C);
        System.out.println(obj instanceof D);
    }
}
