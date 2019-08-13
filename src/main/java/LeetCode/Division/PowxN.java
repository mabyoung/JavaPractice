package LeetCode.Division;

public class PowxN {
    public double pow(double x, int n) {
        if (n < 0) {
            return 1/x * pow(1/x, -(n+1));
        }
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return x * pow(x * x, n / 2);
        } else {
            return pow(x * x, n / 2);
        }
    }

    public double pow1(double x, int n){
        double result = 1;
        double tmp = x;
        for (int i = n; i != 0; i = i/2) {
            if (i %2 !=0){
                result *= tmp;
            }
            tmp *= tmp;
        }
        if (n >0){
            return result;
        }
        return 1/result;
    }
    public static void main(String[] args) {
        PowxN powxN = new PowxN();
        System.out.println(powxN.pow1(2, 7));
    }
}
