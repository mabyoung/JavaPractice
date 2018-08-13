public class Bean {
    class Bean1{
        private int i = 0;
    }
    static class Bean2{
        private int j = 0;
    }

    public static void main(String[] args) {
        Bean bean = new Bean();
        Bean1 bean1 = bean.new Bean1();
        System.out.println(bean1.i);
        Bean2 bean2 = new Bean2();
        System.out.println(bean2.j);
        Test test = new Test();
        Test.Bean3 bean3 = test.new Bean3();
    }
}
class Test{
    class Bean3{
        public int k = 0;
    }
}
