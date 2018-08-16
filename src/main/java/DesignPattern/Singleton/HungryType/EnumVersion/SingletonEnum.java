package DesignPattern.Singleton.HungryType.EnumVersion;

public enum SingletonEnum{
    INSTANCE;
    public void say(){
        System.out.println("我是枚举式单例模式");
    }

    public static void main(String[] args) {
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;
        singletonEnum1.say();
        singletonEnum2.say();
        System.out.println(singletonEnum1.hashCode());
        System.out.println(singletonEnum2.hashCode());
        System.out.println(singletonEnum1 == singletonEnum2);
    }
}
