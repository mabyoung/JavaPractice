package Company.Tencent;

import java.util.Scanner;

public class StructuralPalindrome {
    public static int getLcsLength(char[] charArrayA) {
        char[] charArrayB = new char[charArrayA.length];
        for (int i = 0; i < charArrayA.length; i++) {
            charArrayB[i] = charArrayA[charArrayA.length - i - 1];
        }
        int[][] value = new int[charArrayA.length + 1][charArrayB.length + 1];
        for (int i = 0; i <= charArrayA.length; i++) {
            value[i][0] = 0;
        }
        for (int i = 0; i <= charArrayB.length; i++) {
            value[0][i] = 0;
        }
        for (int i = 1; i <= charArrayA.length; i++) {
            for (int j = 1; j <= charArrayB.length; j++) {
                if (charArrayA[i-1] == charArrayB[j-1]) {
                    value[i][j] = value[i - 1][j - 1] + 1;
                } else {
                    value[i][j] = Math.max(value[i - 1][j], value[i][j - 1]);
                }
            }
        }
        return value[charArrayA.length][charArrayB.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            char[] input = scanner.nextLine().trim().toCharArray();
            int lcsLength = getLcsLength(input);
            System.out.println(input.length-lcsLength);
        }
    }
}
