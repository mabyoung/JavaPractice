package LeetCode.Array;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray peakIndexInMountainArray = new PeakIndexInMountainArray();
        int result = peakIndexInMountainArray.peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0});
        System.out.println(result);
    }
}
