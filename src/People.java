public class People {
    protected void eat(){
        System.out.println("人吃东西");
    }
}
class Animal {
    protected void beat(){
        System.out.println("动物撕咬");
    }
}
class Man extends People{
    private final String name = "df";
    class Woman extends Animal{
        int age = 0;
        String myname = name;
    }

    public static void main(String[] args) {
        Man man = new Man();
        Man.Woman woman = man.new Woman();
        woman.beat();
        man.eat();
    }
}
