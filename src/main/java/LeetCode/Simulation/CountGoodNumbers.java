package LeetCode.Simulation;

import java.util.HashMap;
import java.util.Map;

public class CountGoodNumbers {
    public int countGoodNumbersHelper(long n) {
        long result = 1;
        long i = n / 2;
        long j = i;
        if (n % 2 == 1) {
            j++;
        }
        for (long l = 0; l < i; l++) {
            result *= 4;
            result %= (1000000000 + 7);

        }
        for (long l = 0; l < j; l++) {
            result *= 5;
            result %= (1000000000 + 7);
        }
        return (int) result;
    }

    Map<Long, Integer> map = new HashMap<>();

    public int countGoodNumbers(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 1) {
            return 5;
        }
        if (n == 2) {
            return 20;
        }
        long a = n / 2;
        if (a % 2 == 1) {
            a++;
        }
        long b = n - a;
        long result = (long) countGoodNumbers(a) * (long) countGoodNumbers(b);
        int newResult = (int) (result % (1000000000 + 7));
        map.put(n, newResult);
        return newResult;
    }

    public static void main(String[] args) {
        CountGoodNumbers countGoodNumbers = new CountGoodNumbers();

        for (int i = 1; i < 100; i++) {
            System.out.print(countGoodNumbers.countGoodNumbers(i));
            System.out.print("_");
            System.out.println(countGoodNumbers.countGoodNumbersHelper(i));
        }

    }

}
