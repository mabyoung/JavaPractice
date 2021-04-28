package CrackingTheCodingInterview.Greedy;

public class MaxSum {
    public int getMaxSum(int[] A, int n){
        int result = A[0];
        int currentSum = 0;
        for (int item : A) {
            currentSum += item;
            result = Math.max(result, currentSum);
            if (currentSum < 0){
                currentSum = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSum maxSum = new MaxSum();
        System.out.println(maxSum.getMaxSum(new int[]{1,2,3,-6,1},5));
    }
}
