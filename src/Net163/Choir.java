package Net163;

import java.util.Scanner;

public class Choir {
    private static int choir(int[] student, int n, int k, int d) {
        int[][] maxProduct = new int[n + 1][k + 1];
        int[][] minProduct = new int[n + 1][k + 1];
        int[][] index = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            maxProduct[i][0] = 1;
        }
        for (int i = 0; i <= k; i++) {
            maxProduct[0][i] = 1;
            index[0][i] = i;
        }
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                if (student[i-1] < 0) {
                    minProduct[i][j] = Math.min(minProduct[i - 1][j], minProduct[i][j - 1]);
                    minProduct[i][j] = Math.min(minProduct[i][j], maxProduct[i - 1][j - 1] * student[i-1]);
                    maxProduct[i][j] = Math.max(maxProduct[i - 1][j], maxProduct[i][j - 1]);
                    maxProduct[i][j] = Math.max(maxProduct[i][j], minProduct[i - 1][j - 1] * student[i-1]);
//                    if (maxProduct[i - 1][j - 1] > 0 && minProduct[i-1][j-1]>0) {
//                        minProduct[i][j] = Math.min(minProduct[i - 1][j], minProduct[i][j - 1]);
//                        minProduct[i][j] = Math.min(minProduct[i][j], maxProduct[i - 1][j - 1] * student[i]);
//                        maxProduct[i][j] = Math.max(maxProduct[i - 1][j], maxProduct[i][j - 1]);
//                        maxProduct[i][j] = Math.max(maxProduct[i][j], minProduct[i - 1][j - 1] * student[i]);
//                    } else if (maxProduct[i - 1][j - 1] > 0 && minProduct[i-1][j-1]<0){
//                        minProduct[i][j] = Math.min(minProduct[i - 1][j], minProduct[i][j - 1]);
//                        minProduct[i][j] = Math.min(minProduct[i][j], maxProduct[i - 1][j - 1] * student[i]);
//                        maxProduct[i][j] = Math.max(maxProduct[i - 1][j], maxProduct[i][j - 1]);
//                        maxProduct[i][j] = Math.max(maxProduct[i][j], minProduct[i - 1][j - 1] * student[i]);
//                    } else if (maxProduct[i - 1][j - 1] <0 && minProduct[i-1][j-1]<0){
//                        minProduct[i][j] = Math.min(minProduct[i - 1][j], minProduct[i][j - 1]);
//                        minProduct[i][j] = Math.min(minProduct[i][j], maxProduct[i - 1][j - 1] * student[i]);
//                        maxProduct[i][j] = Math.max(maxProduct[i - 1][j], maxProduct[i][j - 1]);
//                        maxProduct[i][j] = Math.max(maxProduct[i][j], minProduct[i - 1][j - 1] * student[i]);
//                    }
                } else if(student[i-1] > 0){
                    minProduct[i][j] = Math.min(minProduct[i - 1][j], minProduct[i][j - 1]);
                    minProduct[i][j] = Math.min(minProduct[i][j], minProduct[i - 1][j - 1] * student[i-1]);
                    maxProduct[i][j] = Math.max(maxProduct[i - 1][j], maxProduct[i][j - 1]);
                    maxProduct[i][j] = Math.max(maxProduct[i][j], maxProduct[i - 1][j - 1] * student[i-1]);
//                    if (maxProduct[i - 1][j - 1] > 0 && minProduct[i-1][j-1]>0) {
//                        minProduct[i][j] = Math.min(minProduct[i - 1][j], minProduct[i][j - 1]);
//                        minProduct[i][j] = Math.min(minProduct[i][j], minProduct[i - 1][j - 1] * student[i]);
//                        maxProduct[i][j] = Math.max(maxProduct[i - 1][j], maxProduct[i][j - 1]);
//                        maxProduct[i][j] = Math.max(maxProduct[i][j], maxProduct[i - 1][j - 1] * student[i]);
//                    } else if (maxProduct[i - 1][j - 1] > 0 && minProduct[i-1][j-1]<0){
//                        minProduct[i][j] = Math.min(minProduct[i - 1][j], minProduct[i][j - 1]);
//                        minProduct[i][j] = Math.min(minProduct[i][j], maxProduct[i - 1][j - 1] * student[i]);
//                        maxProduct[i][j] = Math.max(maxProduct[i - 1][j], maxProduct[i][j - 1]);
//                        maxProduct[i][j] = Math.max(maxProduct[i][j], minProduct[i - 1][j - 1] * student[i]);
//                    } else if (maxProduct[i - 1][j - 1] <0 && minProduct[i-1][j-1]<0){
//                        minProduct[i][j] = Math.min(minProduct[i - 1][j], minProduct[i][j - 1]);
//                        minProduct[i][j] = Math.min(minProduct[i][j], maxProduct[i - 1][j - 1] * student[i]);
//                        maxProduct[i][j] = Math.max(maxProduct[i - 1][j], maxProduct[i][j - 1]);
//                        maxProduct[i][j] = Math.max(maxProduct[i][j], minProduct[i - 1][j - 1] * student[i]);
//                    }
                }
            }
        }
        return maxProduct[n][k];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        int[] student = new int[n];
        String[] split = scanner.nextLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            student[i] = Integer.parseInt(split[i]);
        }
        split = scanner.nextLine().trim().split(" ");
        int k = Integer.parseInt(split[0]);
        int d = Integer.parseInt(split[1]);
        int choir = choir(student, n, k, d);
        System.out.println(choir);
    }
}
