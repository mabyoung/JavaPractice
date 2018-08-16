package DesignPattern.Factory.FactoryMethod.BaseVersion;

public class SquareFactory implements Factory{
    @Override
    public Shape getShape() {
        return new Square();
    }
}
