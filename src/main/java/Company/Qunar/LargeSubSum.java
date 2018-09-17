package Company.Qunar;

import java.util.*;

/**
 * 求数组的最大连续子数组和
 */
public class LargeSubSum {
    public static int largeSubSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int currentSum = array[0];
        int maxSum = array[0];
        for (int i=1;i<array.length;i++){
            if (currentSum < 0 && array[i]>currentSum){
                currentSum = array[i];
            }else {
                currentSum += array[i];
            }
            if (currentSum>maxSum){
                maxSum=currentSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(" ");
        int[] array = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        System.out.println(largeSubSum(array));
    }
}
