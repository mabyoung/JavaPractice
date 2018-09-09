package Company.CreditEase;

import java.util.Scanner;

/**
 * Created by rui on 2018/9/8.
 */
public class Bank {
    public static void main(String[] args) {
        Scanner scanenr = new Scanner(System.in);
        Long n = scanenr.nextLong() % 100003;
        Long w = scanenr.nextLong();
        Long sum1 = n;
        Long sum2 = n;
        for (int i = 1; i < w; i++) {
            sum1 *= n;
            sum1 %= 100003;
        }
        for (int i = 1; i < w; i++) {
            sum2 *= (n - 1);
            sum2 %= 100003;
        }
        System.out.println((sum1 - sum2) % 100003);
    }
}
