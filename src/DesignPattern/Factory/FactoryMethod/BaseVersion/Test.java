package DesignPattern.Factory.FactoryMethod.BaseVersion;

/**
 * 工厂方法模式是简单工厂的仅一步深化，在工厂方法模式中，我们不再提供一个统一的工厂类来创建所有的对象，而是针对不同的对象提供不同的工厂
 * 也就是说每个对象都有一个与之对应的工厂
 */
public class Test {
    public static void main(String[] args) {
        Factory circleFactory = new CircleFactory();
        Factory squareFactory = new SquareFactory();
        Factory rectangleFactory = new RectangleFactory();
        Shape circle = circleFactory.getShape();
        Shape square = squareFactory.getShape();
        Shape rectangle = rectangleFactory.getShape();
        circle.draw();
        square.draw();
        rectangle.draw();
    }
}
