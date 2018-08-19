package Company.Beike;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by rui on 2018/8/18.
 */
public class SumOfSquareRoot {
    public static void sumOfSquareRoot(double n , int m){
        double sum = n;
        for (int i = 1;i<m;i++){
            n = Math.sqrt(n);
            sum += n;
        }
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(sum));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] split = scanner.nextLine().trim().split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            sumOfSquareRoot(n, m);
        }
    }
}
