package SwordOffer.LoopAndRecursion;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 */
public class JumpFloor {
    public static int jumpFloor(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int a = 1, b = 2, tmp;
        for (int i = 2; i < target; i++) {
            tmp = b;
            b += a;
            a = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(jumpFloor(i));
        }
    }
}
