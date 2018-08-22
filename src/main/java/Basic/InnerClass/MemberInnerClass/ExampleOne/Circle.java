package Basic.InnerClass.MemberInnerClass.ExampleOne;

/**
 * 1.成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
 * 2.当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员
 * 3.外部类不能直接访问内部类的成员，如果要访问成员内部类的成员，必须先创建一个成员内部类的对象
 * 4.成员内部类是依附外部类而存在的，也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象
 * 5.内部类可以拥有public、protected、default、private访问权限,外部类只能被public、default两种权限修饰
 */
public class Circle {
    private double radius;
    private static int count = 1;
    private static Draw instance;

    Circle(double radius) {
        this.radius = radius;
        Draw draw = new Draw();
        draw.drawShape();
    }

    Draw getInnerInstance() {
        if (instance == null) {
            synchronized (Circle.class) {
                if (instance == null) {
                    instance = new Draw();
                }
            }
        }
        return instance;
    }

    private class Draw {
        public void drawShape() {
            double radius = 1;
            System.out.println("内部类半径为：" + radius);
            System.out.println("外部类半径为：" + Circle.this.radius);
            System.out.println("数量为：" + count);
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Draw draw1 = circle.new Draw();
        Draw draw2 = circle.getInnerInstance();
        draw1.drawShape();
        draw2.drawShape();
    }
}
