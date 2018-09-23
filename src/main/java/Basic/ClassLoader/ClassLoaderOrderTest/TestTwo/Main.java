package Basic.ClassLoader.ClassLoaderOrderTest.TestTwo;

/**
 * Created by rui on 2018/9/12.
 */
class SuperClass{
    static {
        System.out.println("父类初始化");
    }
    public static int value = 66;
}
class Subclass{
    static {
        System.out.println("子类初始化");
    }
    private static final SuperClass superClass = new SuperClass();

    public static void test(){
        SuperClass superClass = new SuperClass();
    }
}

public class Main {
    public static int[] move(int[] array, int k){
        int[] result = new int[array.length];
        for (int i=0;i<array.length-k;i++){
            result[i+k] = array[i];
        }
        for (int i=0;i<k;i++){
            result[i] = array[i+k-1];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        int[] result = move(array, 3);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
//        Subclass subclass = new Subclass();
//        System.out.println(subclass.value);
    }
}
