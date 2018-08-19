package Company.Beike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rui on 2018/8/18.
 */
public class NarcissisticNumber {
    public static boolean isNarcissisticNumber(int num) {
        int sum = 0;
        int tmp = num;
        do {
            sum += Math.pow(tmp % 10, 3);
            tmp = tmp / 10;
        } while (tmp > 0);
        return sum == num;
    }

    public static List<Integer> getNarcissisticNumber(int begin, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = begin; i <= end; i++) {
            if (isNarcissisticNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] split = scanner.nextLine().trim().split(" ");
            int begin = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            List<Integer> result = getNarcissisticNumber(begin, end);
            if (result == null || result.size() == 0) {
                System.out.println("no");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i == 0) {
                        System.out.print(result.get(i));
                    } else {
                        System.out.print(" " + result.get(i));
                    }
                }
                System.out.println();
            }
        }
    }
}
