package DesignPattern.Factory.AbstractFactory.BaseVersion;

public class Test {
    public static void main(String[] args) {
        AK_Factory akFactory = new AK_Factory();
        Gun akFactoryGun = akFactory.getGun();
        Bullet akFactoryBullet = akFactory.getBullet();
        M4A1_Factory m4A1Factory = new M4A1_Factory();
        Gun m4A1FactoryGun = m4A1Factory.getGun();
        Bullet m4A1FactoryBullet = m4A1Factory.getBullet();
        akFactoryBullet.load();
        akFactoryGun.shooting();
        m4A1FactoryBullet.load();
        m4A1FactoryGun.shooting();
    }
}
