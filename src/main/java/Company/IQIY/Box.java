package Company.IQIY;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Bob有N个空盒子，第i个盒子是边长为a[i]的立方体，如果一个盒子的边长严格小于另一个盒子，并且大盒子里面没有其他小盒子，
 * 小盒子也没有放入其他大盒子中，那么这个小盒子可以放入大盒子。Bob可以根据条件任意的放盒子，因为他想看见最少数量的盒子。
 * 没有放入其他盒子的盒子是可以被看到的，请你帮Bob确定能看见盒子的最少数量。
 */
public class Box {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        if (n <= 1){
            System.out.println(1);
            return;
        }
        Arrays.sort(input);
        int index = input[n-1];
        input[n-1] = -1;
        int count = 1;
        int result = 0;
        boolean flag = false;
        for (;;){
            if (count == n){
                System.out.println(result);
                return;
            }
            for (int i=n-2;i>=0;i--){
                if (input[i]!=-1&&input[i]<index){
                    index = input[i];
                    input[i]=-1;
                    count ++;
                    if (!flag){
                        result++;
                        flag = true;
                    }
                }
            }
            flag = false;
        }
    }
}
