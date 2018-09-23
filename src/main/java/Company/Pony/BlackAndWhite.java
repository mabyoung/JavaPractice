package Company.Pony;

import java.util.*;

/**
 * ...............
 ...............
 ...............
 ...............
 ...............
 ...............
 ...............
 ......BW.......
 ......WB.......
 ...............
 ...............
 ...............
 ...............
 ...............
 ...............
 */
public class BlackAndWhite {
    private static char[][] boad;
    private static final int n = 15;

    public static boolean isSomeBodyWin(int i, int j, char target) {
        if (boad[i][j] != target) {
            return false;
        }
        if (i <= n-5 && boad[i + 1][j] == target && boad[i + 2][j] == target && boad[i + 3][j] == target && boad[i + 4][j] == target) {
            return true;
        }
        if (j <= n-5 && boad[i][j + 1] == target && boad[i][j + 2] == target && boad[i][j + 3] == target && boad[i][j + 4] == target) {
            return true;
        }
        if (i <= n-5 && j <= n-5 && boad[i + 1][j + 1] == target && boad[i + 2][j + 2] == target && boad[i + 3][j + 3] == target && boad[i + 4][j + 4] == target){
            return true;
        }
        if (i <= n-5 && j >= 4 && boad[i + 1][j - 1] == target && boad[i + 2][j - 2] == target && boad[i + 3][j - 3] == target && boad[i + 4][j - 4] == target){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int mycase = 0;
        int whiteCount = 0;
        int blackCount = 0;
        boolean whiteFlag = false;
        boolean blackFlag = false;
        Scanner scanner = new Scanner(System.in);
        boad = new char[n][n];
        for (int i = 0; i < n; i++) {
            boad[i] = scanner.nextLine().trim().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boad[i][j] == 'B'){
                    blackCount++;
                    if (isSomeBodyWin(i, j, 'B')){
                        mycase = 1;
                        blackFlag = true;
                    }
                }else if (boad[i][j] == 'W'){
                    whiteCount++;
                    if (isSomeBodyWin(i, j, 'W')){
                        mycase = 2;
                        whiteFlag = true;
                    }
                }
            }
        }
        if (blackCount-whiteCount>1 || blackCount-whiteCount<0){
            mycase = 4;
        }else if (blackCount+whiteCount == n*n && !blackFlag && !whiteFlag){
            mycase = 3;
        }else{
            if (mycase == 0){
                mycase = 5;
            }
        }
        if (blackFlag && whiteFlag){
            mycase = 4;
        }
        switch (mycase){
            case 1:
                System.out.println("black win");
                break;
            case 2:
                System.out.println("white win");
                break;
            case 3:
                System.out.println("draw");
                break;
            case 4:
                System.out.println("invalid board");
                break;
            case 5:
                System.out.println("not finished");
                break;
        }
    }
}
/*
...............
...............
...............
...............
...............
...............
...............
......BW.......
......WBBBB....
.....W.........
....W..........
...W...........
...............
...............
...............

 */