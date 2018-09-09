package Company.CreditEase;

import java.util.Scanner;

/**
 * Created by rui on 2018/9/8.
 */
public class FindString {
    public static void main(String[] args) {
        Scanner scanenr = new Scanner(System.in);
        String[] split = scanenr.nextLine().trim().split(" ");
        int result = split[0].indexOf(split[1]);
        System.out.println(result);
    }
}
