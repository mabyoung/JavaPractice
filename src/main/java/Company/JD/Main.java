package Company.JD;

/**
 * Created by rui on 2018/9/9.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean inConllection(List<List<Integer>> list, int i) {
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                if (i == integer){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] edges = new int[N][N];
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                edges[a][b] = 1;
                edges[b][a] = 1;
            }
            List<List<Integer>> collect = new ArrayList<>();
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                if (!inConllection(collect, i)) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    for (int j = 0; j < N; j++) {
                        if (j != i && edges[i][j] == 0) {
                            if (inConllection(collect, j)) {
                                flag = false;
                                break;
                            }
                            tmp.add(j);
                        }
                    }
                    collect.add(tmp);
                }
            }
            System.out.println(flag ? "Yes" : "No");
        }
    }
}

