package Company.SANGFOR;
import java.util.*;
public class MinSum {
    public static int getMinSum(int[] array){
        if (array == null || array.length==0){
            return 0;
        }
        int minSum = array[0];
        int sum = array[0];
        for (int i=1;i<array.length;i++){
            if (sum>0){
                if (array[i]<sum){
                    sum = array[i];
                }
            }else{
                sum += array[i];
            }
            if (sum<minSum){
                minSum = sum;
            }
        }
        return minSum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i=0;i<n;i++){
            input[i] = scanner.nextInt();
        }
        System.out.println(getMinSum(input));
    }
}
