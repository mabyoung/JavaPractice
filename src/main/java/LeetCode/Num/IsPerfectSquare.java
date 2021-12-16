package LeetCode.Num;

public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        double sqrt = Math.sqrt(num);
        int sqrtInt = (int) sqrt;
        return (sqrt - sqrtInt) < 0.01;
    }
}
