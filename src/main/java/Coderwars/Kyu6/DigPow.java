package Coderwars.Kyu6;

public class DigPow {
    public static long digPow(int n, int p) {
        char[] chars = String.valueOf(n).toCharArray();
        long sum = 0;
        for (char aChar : chars) {
            sum += Math.pow(aChar-'0', p++);
        }
        if (sum % n == 0){
            return sum/n;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(digPow(89,1));
    }
}
