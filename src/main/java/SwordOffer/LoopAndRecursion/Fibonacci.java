package SwordOffer.LoopAndRecursion;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）n<=39
 */
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n==0){
            return 0;
        }
        int a = 1;
        int b = 1;
        if (n == 1 || n== 2){
            return 1;
        }
        for (int i =2 ;i<n;i++){
            int tmp = b;
            b += a;
            a = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci(i));
        }
    }
}
