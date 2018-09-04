package Company.Ctrip;

import java.util.Scanner;

/**
 * Created by rui on 2018/9/4.
 */
public class NumOf1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        int count = 0;
        while (input != 0) {
            count++;
            input = input & (input - 1);
        }
        System.out.println(count);
    }

}
