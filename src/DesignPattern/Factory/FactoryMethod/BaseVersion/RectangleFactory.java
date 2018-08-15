package DesignPattern.Factory.FactoryMethod.BaseVersion;

public class RectangleFactory implements Factory{
    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}
