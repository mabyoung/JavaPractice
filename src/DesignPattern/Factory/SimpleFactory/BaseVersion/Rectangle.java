package DesignPattern.Factory.SimpleFactory.BaseVersion;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw rectangle");
    }
}
