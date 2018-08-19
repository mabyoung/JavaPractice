package Company.Beike;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rui on 2018/8/18.
 */
public class xiulu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int min = scanner.nextInt();
        long sum = min;
        int input;
        for (int i = 1;i<n;i++){
             input = scanner.nextInt();
            sum += input;
            if (input<min){
                min = input;
            }
        }
        System.out.println(sum - min);

    }
}
