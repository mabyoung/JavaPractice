package Company.ByteDance;

import java.util.Scanner;

/**
 * Created by rui on 2018/8/12.
 */
public class FootballTeam {
    private static int table[][];
    private static int m;
    private static int n;
    private static int num=0;
    private static int max=0;
    private static int count=0;

    private static void findTeam(int i, int j){
        count++;
        if (count > max){
            max=count;
        }
        if (i-1>=0 && j-1>=0 && table[i-1][j-1]==1){
            table[i-1][j-1]=0;
            findTeam(i-1,j-1);
        }
        if (i-1>=0 && table[i-1][j]==1){
            table[i-1][j]=0;
            findTeam(i-1,j);
        }
        if (i-1>=0 && j+1<=n-1 && table[i-1][j+1]==1){
            table[i-1][j+1]=0;
            findTeam(i-1,j+1);
        }
        if (j-1>=0 && table[i][j-1]==1){
            table[i][j-1]=0;
            findTeam(i,j-1);
        }
        if (j+1<=n-1 && table[i][j+1]==1){
            table[i][j+1]=0;
            findTeam(i,j+1);
        }
        if (i+1<=m-1 && j-1>=0 && table[i+1][j-1]==1){
            table[i+1][j-1]=0;
            findTeam(i+1,j-1);
        }
        if (i+1<=m-1 && table[i+1][j]==1){
            table[i+1][j]=0;
            findTeam(i+1,j);
        }
        if (i+1<=m-1 && j+1<=n-1 && table[i+1][j+1]==1){
            table[i+1][j+1]=0;
            findTeam(i+1,j+1);
        }
    }

    private static void footballTeam(){
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (table[i][j] == 1){
                    num++;
                    table[i][j]=0;
                    count=0;
                    findTeam(i,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(",");
        m = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[1]);
        table = new int[m][n];
        for (int i=0;i<m;i++){
            String[] split1 = scanner.nextLine().trim().split(",");
            for (int j=0;j<n;j++){
                table[i][j] =  Integer.parseInt(split1[j]);
            }
        }
        footballTeam();
        System.out.println(num+","+max);
    }
}
