package Company.Pony;

import java.util.*;

/**
 * Created by rui on 2018/9/19.
 */
public class Main {
    public static boolean isValib(int[] array, int index, int value, int gap) {
        if (index == array.length) {
            return true;
        }
        if (!(value == array[index] || (value % array[index] == 0 && (value / array[index]) % 2 == 0))) {
            return false;
        }
        return isValib(array, index + 1, value + gap, gap);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int input[] = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        if (n == 1) {
            System.out.println(input[0]);
        } else {
            int start = input[1];
            for (; ; ) {
                count++;
                int gap = start - input[0];
                if (isValib(input, 1, start, gap)) {
                    int now = input[0];
                    for (int i = 0; i < n; i++) {
                        System.out.print(now + " ");
                        now += gap;
                    }
                    return;
                } else {
                    start *= 2;
                }
                if (count % 10000 == 0) {
                    count = 0;
                    input[0] *= 2;
                    start = input[1];
                }
            }
        }

    }
}
