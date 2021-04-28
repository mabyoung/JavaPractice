package tiba;

/**
 * 请实现有重复数字的有序数组的二分查找。
 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
 */
public class UpperBound {
    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        if (a[n - 1] < v) {
            return n + 1;
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] == v) {
                right = mid;
            } else if (a[mid] > v) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        UpperBound upperBound = new UpperBound();
        int result = upperBound.upper_bound_(5, 4, new int[]{1, 2, 3,3, 4, 5});
        System.out.println(result);
    }
}
