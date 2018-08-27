package Basic.TryCatch.ReturnOrder;

/**
 * 1、当子类对象调用一个方法时，会优先在子类中查找，然后才回去父类中查找。
 * 如果子类调用了父类的方法method1,而method1又调用了method2，那么这个method2还是会优先在子类中查找，找不到才会去父类中查找。
 * 2、如果子类继承了父类的成员变量（前提是可以继承public和protected），而子类没有显示覆盖该成员变量，
 * 那么子类访问到的成员变量和父类访问到的成员变量是同一个变量。任何一个修改后都会影响到另一个。
 * 3、try中的return会在finally语句块之后运行，如果finally语句块中有return语句，那个就直接返回这个return值。
 * 如果没有，就返回try中的return值（finally块中的任何非return操作都不会影响到try中的return值）。
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }

    static class A {
        protected int value;

        public A(int v) {
            setValue(v);
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            try {
                value++;
                return value;
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }

    static class B extends A {
        public B() {
            super(5);
            setValue(getValue() - 3);
        }

        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}
