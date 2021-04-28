package tiba;

/**
 * 从0,1,2,...,n这n+1个数中选择n个数，组成有序数组，找出这n个数中缺失的那个数，要求O(n)尽可能小
 */
public class LossNum {
    /**
     * 找缺失数字
     *
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     */
    public int solve(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return a[left] == left ? left + 1 : left;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        LossNum lossNum = new LossNum();
        int result = lossNum.solve(a);
        System.out.println(result);
    }
}
