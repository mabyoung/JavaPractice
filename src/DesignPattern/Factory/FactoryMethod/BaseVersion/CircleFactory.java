package DesignPattern.Factory.FactoryMethod.BaseVersion;

public class CircleFactory implements Factory{
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
