package DesignPattern.Factory.SimpleFactory.BaseVersion;

public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw square");
    }
}
