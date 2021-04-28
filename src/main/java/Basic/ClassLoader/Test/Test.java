package Basic.ClassLoader.Test;
import Company.Qihoo360.Array;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        int []x[] = {{1,2},{3,4,5},{6,7,8,9}};
        int[][]y=x;
        System.out.println(y[2][1]);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        Collections.sort(list);
        list.add(2);
        Collections.reverse(list);
        System.out.println(list);

    }
}
