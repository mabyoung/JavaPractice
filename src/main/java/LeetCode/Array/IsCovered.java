package LeetCode.Array;

public class IsCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (!isCovered(ranges, i)){
                return false;
            }
        }
        return true;
    }

    public boolean isCovered(int[][] ranges, int item){
        for (int[] range : ranges) {
            if (item >= range[0] && item <= range[1]){
                return true;
            }
        }
        return false;
    }
}
