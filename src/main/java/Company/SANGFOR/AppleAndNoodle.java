package Company.SANGFOR;

import java.util.*;

/**
 * Created by rui on 2018/9/21.
 */
public class AppleAndNoodle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            long a1 = scanner.nextLong();
            long b1 = scanner.nextLong();
            long v1 = scanner.nextLong();
            long a2 = scanner.nextLong();
            long b2 = scanner.nextLong();
            long v2 = scanner.nextLong();
            if (a1 * b2 == b1 * a2) {
                System.out.println("UNKNOWN");
            }else{
                long lastA1 = a1;
                a1 *= a2;
                b1 *= a2;
                v1 *= a2;
                b2 *= lastA1;
                v2 *= lastA1;
                double y = ((double) (v1 - v2)) / (b1 - b2);
                double x = ((v1 - b1 * y)) / a1;
                if (x <= 0 || y <= 0 || (int) (x) != x || (int) (y) != y) {
                    System.out.println("UNKNOWN");
                }else{
                    System.out.println((long) x + " " + (long)y);
                }
            }
        }
    }
}

