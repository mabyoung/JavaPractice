package LeetCode.Array;

import java.util.Arrays;

public class HIndex {
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        int index = citations.length - 1;
        while (index >= 0) {
            if (citations[index] >= citations.length - index) {
                result = citations.length - index;
            }
            index--;
        }
        return result;
    }

    public int hIndex2(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int h = n - mid;
            if (citations[mid] >= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return Math.min(citations[left], n - left);
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int result = hIndex.hIndex2(new int[]{0, 1, 3, 5, 6});
        System.out.println(result);
    }
}
