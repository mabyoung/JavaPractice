package Coderwars.Kyu6;

public class DRoot {
    public static int digital_root(int n) {
        if (n < 10){
            return n;
        }
        int sum = 0;
        for (char aChar : String.valueOf(n).toCharArray()) {
            sum += aChar-'0';
        }
        return digital_root(sum);
    }

    public static void main(String[] args) {
        System.out.println(digital_root(16));
    }
}
