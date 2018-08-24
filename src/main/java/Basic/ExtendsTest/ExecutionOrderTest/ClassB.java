package Basic.ExtendsTest.ExecutionOrderTest;

/**
 * 在继承中代码的执行顺序为：
 * 1.父类静态对象，父类静态代码块
 * 2.子类静态对象，子类静态代码块
 * 3.父类非静态对象，父类非静态代码块
 * 4.父类构造函数
 * 5.子类非静态对象，子类非静态代码块
 * 6.子类构造函数
 */
class ClassA {
    public static ClassA classA = new ClassA();//①输出(A的构造代码块、A的构造方法)
    public ClassA() {
        System.out.println("A的构造方法");//生成classA的对象时执行
    }
    {
        System.out.println("A的构造代码块");//生成classA的对象时执行
    }
    static {
        System.out.println("A的静态代码块");//②输出(A的静态代码块)
    }
}

public class ClassB extends ClassA {
    public ClassA classA = new ClassA();//在生成ClassB的对象时执行，输出(A的构造代码块、A的构造方法)
    public static ClassB classB = new ClassB();//③输出(A的构造代码块、A的构造方法、A的构造代码块、A的构造方法、B的构造代码块、B的构造方法)
    public ClassB() {
        System.out.println("B的构造方法");//生成classB的对象时执行
    }
    {
        System.out.println("B的构造代码块");//生成classB的对象时执行
    }
    static {
        System.out.println("B的静态代码块");//④输出(B的静态代码块)
    }
    public static void main(String[] args) {
        new ClassB();//⑤输出(A的构造代码块、A的构造方法、A的构造代码块、A的构造方法、B的构造代码块、B的构造方法)
    }
}



