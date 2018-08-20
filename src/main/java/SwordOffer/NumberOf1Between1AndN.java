package SwordOffer;

import java.util.Scanner;

public class NumberOf1Between1AndN {
    public static int solve(int n) {
        int count = 0;
        int index = 1;
        int low, high;
        do {
            high = n / index;
            low = n % index;
            if (high % 10 == 0) {
                count += (high / 10) * index;
            } else if (high % 10 == 1) {
                count += (high / 10) * index + low + 1;
            } else {
                count += (high / 10 + 1) * index;
            }
            index *= 10;
        } while (high > 0);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }
}
