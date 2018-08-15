package DesignPattern.Factory.AbstractFactory.BaseVersion;

public class AK_Factory implements Factory{
    @Override
    public Gun getGun() {
        return new AK();
    }

    @Override
    public Bullet getBullet() {
        return new AK_Bullet();
    }
}
