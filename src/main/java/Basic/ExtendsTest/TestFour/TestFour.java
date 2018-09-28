package Basic.ExtendsTest.TestFour;
abstract class A{
    public A(){
        this.print();
    }
    public abstract void print();
}
class B extends A{
    private int value = -1;
    public B(int content){
        this.value = content;
    }
    public void print(){
        System.out.println(this.value);
    }
}
public class TestFour {
    public static void main(String[] args) {
        A a = new B(1);
        B b = new B(2);
        b.print();
    }
}
