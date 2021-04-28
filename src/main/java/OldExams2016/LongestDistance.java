package OldExams2016;

/**
 * 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
 * 给定数组A及它的大小n，请返回最大差值。
 */
public class LongestDistance {
    public int getDis(int[] A, int n) {
        int result = 0;
        int minValue = A[0];
        for (int item : A) {
            minValue = Math.min(minValue, item);
            result = Math.max(result, item - minValue);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestDistance longestDistance = new LongestDistance();
        int result = longestDistance.getDis(new int[]{10, 5}, 2);
        System.out.println(result);
    }
}
