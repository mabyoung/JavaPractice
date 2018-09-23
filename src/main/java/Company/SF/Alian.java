package Company.SF;

import java.util.*;

public class Alian {
    private static int[][] LCSPath;
    public static int getLCS(int[]a, int[]b, int n){
        int[][] LCS = new int[n +1][n+1];
        LCSPath = new int[n][n];
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
        return LCS[n][n];
    }

    public static void printLCS(int[]a, int[]b, int n){
        Set<Integer> set = new HashSet<>();
        int i = n -1, j = n -1;
        while(i >= 0 && j >= 0){
            int lastPath = LCSPath[i][j];
            if (lastPath == 1){
                i--;
            } else if (lastPath == 2){
                set.add(a[i]);
                i--;j--;
            } else if (lastPath == 3){
                j--;
            }
        }
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int item : b) {
            list.add(item);
        }
        for(i = 0;i<n;i++){
            if (!set.contains(a[i])){
                int indexOf = list.indexOf(a[i]);
                result+=Math.abs(indexOf-i);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i=0;i<n;i++){
            b[i] = scanner.nextInt();
        }
        getLCS(a,b,n);
        printLCS(a,b,n);
    }
}
