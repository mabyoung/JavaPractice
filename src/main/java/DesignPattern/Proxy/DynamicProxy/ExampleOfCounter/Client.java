package DesignPattern.Proxy.DynamicProxy.ExampleOfCounter;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Maotai maotai = new Maotai();
        Wuliangye wuliangye = new Wuliangye();
        KingFurong kingFurong = new KingFurong();
        Counter counter1 = new Counter(maotai);
        Counter counter2 = new Counter(wuliangye);
        Counter counter3 = new Counter(kingFurong);
        SellWine sellWine1 = (SellWine) Proxy.newProxyInstance(Maotai.class.getClassLoader(), Maotai.class.getInterfaces(), counter1);
        SellWine sellWine2 = (SellWine) Proxy.newProxyInstance(Wuliangye.class.getClassLoader(), Wuliangye.class.getInterfaces(), counter2);
        SellCigarette sellCigarette = (SellCigarette) Proxy.newProxyInstance(KingFurong.class.getClassLoader(), KingFurong.class.getInterfaces(), counter3);
        sellWine1.introduce();
        sellWine2.introduce();
        sellCigarette.introduce();
    }
}
