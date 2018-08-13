package byteDance;

import java.util.Scanner;

public class MaxMapping {
    private static long[]weight = new long[10];
    private static int[]mychar = new int[10];
    private static int[]tmp = new int[10];
    private static boolean[]prefix = new boolean[10];
    private static long sum = 0;
    private static void getCharWeight(char[][] input, int n){
        for (int i = 0; i < n; i++){
            long nowWeight = 1;
            for (int j = input[i].length-1; j >= 0; j--){
                boolean flag = (j == 0);
                switch (input[i][j]){
                    case 'A': weight[0] += nowWeight;if (flag)prefix[0]=flag;break;
                    case 'B': weight[1] += nowWeight;if (flag)prefix[1]=flag;break;
                    case 'C': weight[2] += nowWeight;if (flag)prefix[2]=flag;break;
                    case 'D': weight[3] += nowWeight;if (flag)prefix[3]=flag;break;
                    case 'E': weight[4] += nowWeight;if (flag)prefix[4]=flag;break;
                    case 'F': weight[5] += nowWeight;if (flag)prefix[5]=flag;break;
                    case 'G': weight[6] += nowWeight;if (flag)prefix[6]=flag;break;
                    case 'H': weight[7] += nowWeight;if (flag)prefix[7]=flag;break;
                    case 'I': weight[8] += nowWeight;if (flag)prefix[8]=flag;break;
                    case 'J': weight[9] += nowWeight;if (flag)prefix[9]=flag;break;
                }
                nowWeight*=10;
            }
        }
        int count=9;
        for (int i = 0; i < 10; i++){
            long max = weight[0];
            int maxIndex = 0;
            for (int j = 0; j < 10; j++){
                if (weight[j] > max){
                    max = weight[j];
                    maxIndex = j;
                }
            }
            mychar[maxIndex] = count;
            count--;
            weight[maxIndex] = -1;
        }
        for (int i = 0; i<=9; i++){
            tmp[mychar[i]] = i;
        }
        if (prefix[tmp[0]]){
            for (int i = 1; i<=9; i++){
                if (!prefix[tmp[i]]){
                    int tmpi = tmp[i];
                    for (int j=i-1;j>=0;j--){
                        tmp[j+1] = tmp[j];
                    }
                    tmp[0]=tmpi;
                    break;
                }
            }
        }
        for (int i = 0; i<=9; i++){
            mychar[tmp[i]] = i;
        }
        for (int i = 0; i < n; i++){
            long cheng = 1;
            for (int j = input[i].length-1; j >= 0; j--){
                switch (input[i][j]){
                    case 'A': sum+=mychar[0]*cheng;break;
                    case 'B': sum+=mychar[1]*cheng;break;
                    case 'C': sum+=mychar[2]*cheng;break;
                    case 'D': sum+=mychar[3]*cheng;break;
                    case 'E': sum+=mychar[4]*cheng;break;
                    case 'F': sum+=mychar[5]*cheng;break;
                    case 'G': sum+=mychar[6]*cheng;break;
                    case 'H': sum+=mychar[7]*cheng;break;
                    case 'I': sum+=mychar[8]*cheng;break;
                    case 'J': sum+=mychar[9]*cheng;break;
                }
                cheng*=10;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        char[][]input= new char[n][];
        for (int i = 0; i < n; i++){
            input[i] = scanner.nextLine().trim().toCharArray();
        }
        getCharWeight(input, n);
    }
}
