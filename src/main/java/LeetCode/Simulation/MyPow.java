package LeetCode.Simulation;

public class MyPow {

    public double myPow(double x, int n) {
        long N = n;
        if (N == 0) {
            return 1;
        } else if (N > 0) {
            return myPositivePow(x, N);
        } else {
            return 1 / myPositivePow(x, -N);
        }
    }

    public double myPositivePow(double x, long n) {
        if (n == 1) {
            return x;
        }
        double y = myPositivePow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        int n = -2147483648;
        System.out.println(-n);
        double result = myPow.myPow(1.00000, -2147483648);
        System.out.println(result);
    }
}
