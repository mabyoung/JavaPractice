package Prototype;

import java.util.ArrayList;

/**
 * Created by rui on 2018/8/12.
 */
public class FullArrangement {
    private static int[] arr = new int[]{1,2,3};
    private static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private static void fullArrangement(int n){
        if (n == arr.length){
            for (int item : arr) {
                System.out.print(item);
            }
            System.out.println();
        }
        for (int i = n;i<arr.length;i++){
            swap(i,n);
            fullArrangement(n+1);
            swap(i,n);
        }
    }
    public static void main(String[] args) {
        fullArrangement(0);
    }
}
