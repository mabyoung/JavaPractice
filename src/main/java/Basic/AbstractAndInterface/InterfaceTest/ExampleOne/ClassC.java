package Basic.AbstractAndInterface.InterfaceTest.ExampleOne;

/**
 * 外部内的访问控制符只能为public和default，因为外部类没有处于任何类的内部，因此 private 和 protected 访问控制符对外部类没有意义。
 */
public class ClassC implements InterfaceB{
    @Override
    public void functionB1() {
        System.out.println("functionB1");
    }
}
