package SwordOffer.Array;

public class MinNumberInRotateArray {
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1){
            return array[0];
        }
        for (int i = 0; i < array.length-1; i++) {
            if (array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return array[array.length-1];
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(array));
    }
}
