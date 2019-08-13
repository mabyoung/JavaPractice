package LeetCode.Search;

public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                if (result[0] == -1) {
                    result[0] = i;
                    result[1] = i;
                } else {
                    result[1] = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SearchForARange searchForARange = new SearchForARange();
        int[] result = searchForARange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int item : result) {
            System.out.print(item);
        }
    }
}
