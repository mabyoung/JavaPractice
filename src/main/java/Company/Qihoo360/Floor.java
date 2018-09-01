package Company.Qihoo360;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by rui on 2018/8/27.
 */
public class Floor {
    public static int[] floor;

    public static int solve(int left, int right){
        HashSet<Integer> set = new HashSet<>();
        for (int i= left-1;i<right;i++){
            set.add(floor[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        floor = new int[n];
        for (int i=0;i<n;i++){
            floor[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        for (int i =0;i<q;i++){
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            System.out.println(solve(left, right));
        }
    }
}
