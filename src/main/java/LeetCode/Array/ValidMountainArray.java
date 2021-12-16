package LeetCode.Array;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int i = 1;
        for (; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                return false;
            } else if (arr[i - 1] > arr[i]) {
                if (i == 1) {
                    return false;
                }
                break;
            }
        }
        if (i == arr.length) {
            return false;
        }
        for (; i < arr.length; i++) {
            if (arr[i - 1] <= arr[i]) {
                return false;
            }
        }
        return true;
    }
}
