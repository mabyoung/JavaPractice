package Company.Net163;

import java.util.Scanner;

/**
 * Created by rui on 2018/8/12.
 */
class Matrix{
    public int a;
    public int b;
}
public class FullArrangement {
    private static Matrix[] arr;
    private static boolean flag = false;
    private static void swap(int i, int j){
        Matrix tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private static void fullArrangement(int n){
        if (n == arr.length){
            for (int i=1;i<n;i++){
                if (arr[i-1].b != arr[i].a){
                    return;
                }
            }
            flag = true;
            return;
        }
        for (int i = n;i<arr.length;i++){
            swap(i,n);
            fullArrangement(n+1);
            swap(i,n);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            arr = new Matrix[n];
            flag = false;
            for (int i = 0; i < n; i++) {
                Matrix matrix = new Matrix();
                matrix.a = scanner.nextInt();
                matrix.b = scanner.nextInt();
                arr[i] = matrix;
            }
            fullArrangement(0);
            if (flag){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
