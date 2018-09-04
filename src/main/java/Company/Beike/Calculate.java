package Company.Beike;

import java.util.Scanner;

/**
 * 假设有这样一个计算器，该计算器只有两个按钮，按下第一个按钮能使显示数值减少1，按下第二个按钮能使显示数值乘以2，
 * 当前显示数值为N，那么至少要按多少次按钮才能使显示数值变成M？
 */
public class Calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long count = 0;
        while (n < (m+1) / 2) {
            n *= 2;
            count++;
        }
        while (n > (m+1) / 2) {
            n--;
            count++;
            if (n == m){
                System.out.println(count);
                return;
            }
        }
        if (n == (m+1) / 2) {
            n *= 2;
            count++;
        }
        while (n > m) {
            n--;
            count++;
        }
        System.out.println(count);
    }
}
