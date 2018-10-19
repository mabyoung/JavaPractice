package PAT;

import java.util.Scanner;

public class AplusB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            if (a + b > c) {
                System.out.println("Case #" + i + ": true");
            } else {
                System.out.println("Case #" + i + ": false");
            }
        }
    }
}
