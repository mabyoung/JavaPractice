package OldExams2016;

public class BinarySearch {
    public int getPos(int[] A, int n, int val) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == val) {
                while(mid >0 && A[mid-1] == A[mid]){
                    mid--;
                }
                return mid;
            } else if (A[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.getPos(new int[]{1,3,5,7,9}, 5, 3);
        System.out.println(result);
    }
}
