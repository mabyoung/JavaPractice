package Company.Net163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rui on 2018/9/8.
 */
public class StringYS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        while (n-- > 0) {
            char[] chars = scanner.nextLine().trim().toCharArray();
            int start = 0, end = 0;
            for (int i = 0; i < chars.length; i++) {
                if (i > 0) {
                    if (chars[i - 1] + 1 != chars[i]) {
                        if (end - start + 1 >= 4) {
                            for (int j = start + 1; j < end; j++) {
                                chars[j] = '-';
                            }
                        }
                        start = ++end;
                    } else {
                        end++;
                    }
                }
            }
            if (end - start + 1 >= 4) {
                for (int j = start + 1; j < end; j++) {
                    chars[j] = '-';
                }
            }
            for (int j = 0; j < chars.length; j++) {
                if (!(j > 0 && chars[j - 1] == '-' && chars[j] == '-')) {
                    System.out.print(chars[j]);
                }
            }
            System.out.println();
        }
    }
}
