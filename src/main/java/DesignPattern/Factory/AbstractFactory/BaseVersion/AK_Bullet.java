package DesignPattern.Factory.AbstractFactory.BaseVersion;

public class AK_Bullet implements Bullet{
    @Override
    public void load() {
        System.out.println("Loading bullets for AK");
    }
}
