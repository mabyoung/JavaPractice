package Company.SANGFOR;

import java.util.*;

/**
 * Created by rui on 2018/9/21.
 */
public class Water {
    public static int solve(int[] array) {
        int i = 0,j =array.length-1;
        int max = 0;
        int cur = 0;
        while(i<j){
            cur = (j-i)*Math.min(array[i],array[j]);
            if (array[i]<array[j]){
                i++;
            }else{
                j--;
            }
            if (cur >max){
                max = cur;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int k = scanner.nextInt();
            int[] input = new int[k];
            for (int i = 0; i < k; i++) {
                input[i] = scanner.nextInt();
            }
            System.out.println(solve(input));
        }
    }
}
/*
2
3
2 1 3
3
2 4 3

4
5
 */