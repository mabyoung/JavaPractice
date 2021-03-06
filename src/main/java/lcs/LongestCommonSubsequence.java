package lcs;

import java.util.Scanner;
import java.util.Stack;

public class LongestCommonSubsequence {
    private int[][] LCSPath;
    public int getLCS(char[]a, char[]b){
        int[][] LCS = new int[a.length+1][b.length+1];
        LCSPath = new int[a.length][b.length];
        for (int index = 0; index < a.length; index++){
            LCS[index][0] = 0;
        }
        for (int index = 0; index < b.length; index++){
            LCS[0][index] = 0;
        }
        for (int i = 1; i <= a.length; i++){
            for (int j = 1; j <= b.length; j++){
                if (a[i-1] == b[j-1]){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                    LCSPath[i-1][j-1] = 2;
                } else {
                    if (LCS[i-1][j] > LCS[i][j-1]){
                        LCS[i][j] = LCS[i-1][j];
                        LCSPath[i-1][j-1] = 1;
                    } else {
                        LCS[i][j] = LCS[i][j-1];
                        LCSPath[i-1][j-1] = 3;
                    }
                }
            }
        }
        return LCS[a.length][b.length];
    }

    public void printLCS(char[]a, char[]b){
        Stack<Character> stack = new Stack<>();
        int i = a.length-1, j = b.length -1;
        while(i >= 0 && j >= 0){
            int lastPath = LCSPath[i][j];
            if (lastPath == 1){
                i--;
            } else if (lastPath == 2){
                stack.push(a[i]);
                i--;j--;
            } else if (lastPath == 3){
                j--;
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入第一个字符串：");
        Scanner scanner = new Scanner(System.in);
        char[] a = scanner.nextLine().trim().toCharArray();
        System.out.println("请输入第一个字符串：");
        char[] b = scanner.nextLine().trim().toCharArray();
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int result = longestCommonSubsequence.getLCS(a, b);
        System.out.println("最长公共子序列长度："+result);
        longestCommonSubsequence.printLCS(a, b);
    }
}
