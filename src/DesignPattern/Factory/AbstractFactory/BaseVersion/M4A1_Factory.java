package DesignPattern.Factory.AbstractFactory.BaseVersion;

public class M4A1_Factory implements Factory{
    @Override
    public Gun getGun() {
        return new M4A1();
    }

    @Override
    public Bullet getBullet() {
        return new M4A1_Bullet();
    }
}
