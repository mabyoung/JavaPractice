package SwordOffer.Array;

import java.util.Arrays;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Multiply {
    public static int[] multiply(int[] A) {
        int length = A.length;
        int[] head = new int[length];
        int[] tail = new int[length];
        head[0] = 1;
        for (int i = 1; i < length; i++) {
            head[i] = head[i - 1] * A[i - 1];
        }
        tail[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            tail[i] = tail[i + 1] * A[i + 1];
        }
        int[] B = new int[length];
        for (int i = 0; i < length; i++) {
            B[i] = head[i] * tail[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] multiply = multiply(A);
        System.out.println(Arrays.toString(multiply));
    }
}
