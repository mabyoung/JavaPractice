package lcs;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Scanner;

public class LongestCommonSubstring {
    int LCS[][];
    int aLength,bLength;
    int maxLength = 0,maxi,maxj;
    int getLCSLength(char[] a, char[] b){
        aLength = a.length;
        bLength = b.length;
        LCS = new int[aLength+1][bLength+1];
        for (int index = 0; index <= a.length; index++){
            LCS[index][0] = 0;
        }
        for (int index = 0; index <= b.length; index++){
            LCS[0][index] = 0;
        }
        for (int i = 1; i <= a.length; i++){
            for (int j = 1; j <= b.length; j++){
                if (a[i-1] == b[j-1]){
                    LCS[i][j] =  LCS[i-1][j-1] + 1;
                    if (LCS[i][j] > maxLength){
                        maxLength = LCS[i][j];
                        maxi = i-1;
                        maxj = j-1;
                    }
                } else {
                    LCS[i][j] = 0;
                }
            }
        }
        return maxLength;
    }

    void printLCS(char[] a){
        if (maxLength > 0){
            for (int index = maxi - maxLength + 1; index <= maxi; index++){
                System.out.print(a[index]);
            }
        }
    }

    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        System.out.println("请输入第一个字符串：");
        Scanner scanner = new Scanner(System.in);
        char[] a = scanner.nextLine().trim().toCharArray();
        System.out.println("请输入第一个字符串：");
        char[] b = scanner.nextLine().trim().toCharArray();
        int result = lcs.getLCSLength(a, b);
        System.out.println("最长公共子串长度："+result);
        lcs.printLCS(a);
    }
}
