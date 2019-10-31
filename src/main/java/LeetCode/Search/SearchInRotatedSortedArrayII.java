package LeetCode.Search;

/**
 * 继续思考题目 "Search in Rotated Sorted Array":
 * 如果数组种允许有重复元素怎么办？
 * 会影响时间复杂度吗？是怎样影响时间复杂度的，为什么？
 * 编写一个函数判断给定目标值是否在数组中。
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[left] == A[mid] && A[mid] == A[right]) {
                for (int item : A) {
                    if (item == target) {
                        return true;
                    }
                }
                return false;
            }
            if (A[left] <= A[mid]) {
                if (A[left] <= target && target <= A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid] <= target && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII searchInRotatedSortedArrayII = new SearchInRotatedSortedArrayII();
        boolean result = searchInRotatedSortedArrayII.search(new int[]{1}, 1);
        System.out.println(result);
    }
}
