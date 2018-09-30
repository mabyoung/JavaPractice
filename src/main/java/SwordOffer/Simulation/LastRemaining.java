package SwordOffer.Simulation;

/**
 * 编号为0~n-1的小朋友围成圈报数。从0开始报数，报到m-1的小朋友出列，并且他的下一个小朋友从0接着开始报数。
 */
public class LastRemaining {
    public static int lastRemaining(int n, int m) {
        int[] child = new int[n];
        int index = 0;
        int childCount = n;
        int numCount = 0;
        while (childCount > 1) {
            if (child[index % n] == 0) {
                if (numCount == m-1){
                    child[index % n] = 1;
                    childCount--;
                    numCount = -1;
                }
                numCount++;
            }
            index++;
        }
        for (int i=0;i<n;i++){
            if (child[i]==0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(3, 1));
    }
}
