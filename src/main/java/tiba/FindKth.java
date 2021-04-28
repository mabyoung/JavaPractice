package tiba;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 */
public class FindKth {
    public int findKth(int[] a, int n, int K) {
        return findKth(a, 0, n - 1, K);
    }

    /**
     * 找第k大的数
     *
     * @param a     数组
     * @param left  左边位置
     * @param right 右边位置
     * @param k     要找的第k大
     * @return 第k大的值
     */
    public int findKth(int[] a, int left, int right, int k) {
        int tmp = a[left];
        int low = left;
        int high = right;
        while (low < high) {
            while (low < high && a[high] <= tmp) {
                high--;
            }
            if (low != high) {
                a[low++] = a[high];
            }
            while (low < high && a[low] >= tmp) {
                low++;
            }
            if (low != high) {
                a[high--] = a[low];
            }
        }
        if (low + 1 == k) {
            return tmp;
        } else if (low + 1 < k) {
            return findKth(a, low + 1, right, k);
        } else {
            return findKth(a, left, low - 1, k);
        }
    }

    public static void main(String[] args) {
        FindKth findKth = new FindKth();
        int[] a =  new int[]{1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663};
        int result = findKth.findKth(a, 49, 24);
//        result = findKth.findKth(new int[]{1, 3, 4, 5, 2, 6, 7,5}, 8, 6);
        System.out.println(result);
    }
}
