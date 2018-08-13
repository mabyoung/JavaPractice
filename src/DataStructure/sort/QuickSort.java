package DataStructure.sort;

public class QuickSort {
    void sort(int R[], int low, int high){
        if (low < high){
            int i = low, j = high, pirot=R[i];
            while (i <j){
                while (i<j && R[j]>=pirot){
                    j--;
                }
                if (i <j){
                    R[i++]=R[j];
                } else {
                    break;
                }
                while (i<j && R[i]<=pirot){
                    i++;
                }
                if (i < j){
                    R[j--]=R[i];
                } else {
                    break;
                }
            }
            R[i]=pirot;
            sort(R, low, i-1);
            sort(R, i+1, high);
        }
    }

    public static void main(String[] args) {
        int R[] = {2,3,5,1,3,4,5,8,3,5,2};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(R, 0, 10);
        for (int index = 0; index < R.length; index++){
            System.out.println(R[index]);
        }
    }
}
