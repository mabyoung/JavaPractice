package LeetCode.Search;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (A[low] < target) {
            return low + 1;
        } else {
            return low;
        }
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
