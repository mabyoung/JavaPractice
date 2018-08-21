package SwordOffer;

import java.util.Scanner;

public class GetUglyNumber {
    public static int getUglyNumber(int index) {
        if (index == 0){
            return 0;
        }
        int[] uglyList = new int[index];
        uglyList[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            int min = Math.min(Math.min(2 * uglyList[t2], 3 * uglyList[t3]), 5 * uglyList[t5]);
            if (2 * uglyList[t2] == min) {
                t2++;
            }
            if (3 * uglyList[t3] == min) {
                t3++;
            }
            if (5 * uglyList[t5] == min) {
                t5++;
            }
            uglyList[i] = min;
        }
        return uglyList[index - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        for (int i = 1; i <= index; i++) {
            System.out.println(getUglyNumber(i));
        }
    }
}
