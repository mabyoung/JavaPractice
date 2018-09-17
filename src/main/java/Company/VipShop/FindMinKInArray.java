package Company.VipShop;
import java.util.*;

/**
 * 行列递增的数组中，找第k小的数
 */
class Locate{
    int i;
    int j;
    Locate(int i , int j){
        this.i =i;
        this.j = j;
    }
}
public class FindMinKInArray {
    public static Locate getMinLocate(List<Locate> list, int[][]matrix){
        Locate minLocate = null;
        int minNum = Integer.MAX_VALUE;
        for (Locate locate : list) {
            if (matrix[locate.i][locate.j]<minNum){
                minLocate = locate;
                minNum = matrix[locate.i][locate.j];
            }
        }
        return minLocate;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int matrix[][] = new int[n][n];
        int help[][] = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        List<Locate> list = new ArrayList<>();
        Locate locate = new Locate(0,0);
        int count =1;
        list.add(locate);
        help[0][0] = 1;
        for(;;){
            Locate tmp = getMinLocate(list, matrix);
            if (count == k){
                System.out.println(matrix[tmp.i][tmp.j]);
                return;
            }
            list.remove(tmp);
            count++;
            if (tmp.i+1<n&&help[tmp.i+1][tmp.j]==0){
                help[tmp.i+1][tmp.j]=1;
                Locate newLocate = new Locate(tmp.i+1,tmp.j);
                list.add(newLocate);
            }
            if (tmp.j+1<n&&help[tmp.i][tmp.j+1]==0){
                help[tmp.i][tmp.j+1]=1;
                Locate newLocate = new Locate(tmp.i,tmp.j+1);
                list.add(newLocate);
            }
        }
    }
}
