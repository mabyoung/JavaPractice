package LeetCode.Simulation;

public class MySqrt {
    public int mySqrt(int x) {
        int left = 0;
        int right = Math.min(x / 2, 2);
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            long value = (long) mid * mid;
            if (value == x) {
                return mid;
            } else if (value > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(2147483647));
    }
}
