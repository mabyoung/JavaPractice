package DesignPattern.Factory.SimpleFactory.ReflectionVersion;

public class Test {
    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.getShape(Circle.class);
        Shape shape2 = ShapeFactory.getShape(Rectangle.class);
        Shape shape3 = ShapeFactory.getShape(Square.class);
        shape1.draw();
        shape2.draw();
        shape3.draw();
    }
}
