package Company.Tencent;
import java.util.*;
/**
 * Created by rui on 2018/9/16.
 */
public class BigCity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] edges = new int[n][n];
        while (m-->0){
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            edges[a][b] = 1;
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                for (int k = 0;k<n;k++){
                    if (edges[j][i]==1 && edges[i][k]==1){
                        edges[j][k] = 1;
                    }
                }
            }
        }
        int count = 0;
        for (int i= 0;i<n;i++){
            int row = 0;
            int col = 0;
            for (int j = 0;j<n;j++){
                if (edges[i][j] == 1){
                    row++;
                }
                if (edges[j][i] == 1){
                    col++;
                }
            }
            if (col>row){
                count++;
            }
        }
        System.out.println(count);
    }
}
