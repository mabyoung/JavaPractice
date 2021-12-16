package LeetCode.Simulation;

public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        int weight = 1;
        while (5 * weight <= n) {
            result += getFiveNum(weight) + 1;
            weight++;
        }
        return result;
    }

    public int getFiveNum(int num) {
        int result = 0;
        while (num % 5 == 0) {
            result++;
            num /= 5;
        }
        return result;
    }
}
