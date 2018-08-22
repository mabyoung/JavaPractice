package Basic.AbstractAndInterface.InterfaceTest.ExampleOne;


/**
 * 1、子类构造函数调用父类构造函数用super
 * 2、子类重写父类方法后，若想调用父类中被重写的方法，用super
 * 3、未被重写的方法可以直接调用
 */
public class ClassD extends ClassC {

    public void functionD1(){
        functionB1();
    }

    public static void main(String[] args) {
        ClassD classD = new ClassD();
        classD.functionD1();
        Sc
    }
}
