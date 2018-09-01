package Company.Qihoo360;

import java.util.Scanner;

/**
 * Created by rui on 2018/8/27.
 */
public class City {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long x = scanner.nextInt();
        long y = scanner.nextInt();
        long minX = x;
        long minY = y;
        long maxX = x;
        long maxY = y;
        for (int i=1;i<n;i++){
            x = scanner.nextLong();
            y = scanner.nextLong();
            if (x<minX){
                minX = x;
            }
            if(x>maxX){
                maxX = x;
            }
            if (y<minY){
                minY = y;
            }
            if (y>maxY){
                maxY = y;
            }

        }
        long max = Math.max(maxX - minX, maxY - minY);
        System.out.println(max*max);
    }
}
