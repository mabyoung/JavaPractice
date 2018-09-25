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
        /*String numberStr = "2 ks 1 -1";
        String[] split = numberStr.split(" ");
        List<Integer> list = new ArrayList<>();
        for (String str : split) {
            if ((str.charAt(0)>='0'&&str.charAt(0)<='9')||str.charAt(0)=='-'){
                System.out.println(Integer.parseInt(str));
                list.add(Integer.parseInt(str));
            }
        }
        int currentSum = 0;
        int maxSum = 0;
        for (int i=0;i<list.size();i++){
            currentSum += list.get(i);
            if (currentSum < 0){
                currentSum = 0;
            }
            if (currentSum>maxSum){
                maxSum = currentSum;
            }
        }
        System.out.println(maxSum);*/
    }
}
