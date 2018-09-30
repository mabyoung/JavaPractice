package Company.IQIY;

import java.util.Scanner;

/**
 * 清雨又在吃自助餐了。
 * 排在清雨面前的有N种食物，排成一排，清雨可以选择其中的若干种食物，但是不能连续选择相邻的食物。
 * 因为清雨很挑食，当所有食物都不合口味时，他可以一种都不选，即一个都不选也算为一种方法。
 * 请问他有多少种选择食物的方法呢？
 */
public class Eat {
    public static long solve(int n) {
        if (n == 1) {
            return 2;
        }
        if (n == 2){
            return 3;
        }
        long a = 2;
        long b = 3;
        for (int i = 2;i<n;i++){
            long tmp = b;
            b += a;
            a = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }
}
