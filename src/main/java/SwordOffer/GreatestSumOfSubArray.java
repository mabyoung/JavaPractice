package SwordOffer;

/**
 * Created by rui on 2018/8/18.
 */
public class GreatestSumOfSubArray {
    public static int findGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (sum<0 && array[i]> sum){
                sum = array[i];
            }else if (sum>=0){
                sum+=array[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-2,-8,-1,-5,-9};
        int result = findGreatestSumOfSubArray(array);
        System.out.println(result);
    }
}
