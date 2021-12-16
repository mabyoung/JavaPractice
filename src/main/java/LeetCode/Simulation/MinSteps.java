package LeetCode.Simulation;

public class MinSteps {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int result = 0;
        while (true) {
            int factor = getFactor(n);
            if (factor != 1) {
                result += factor;
                n /= factor;
            } else {
                result += n;
                return result;
            }
        }
    }

    public int getFactor(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
