package SwordOffer.LoopAndRecursion;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 */
public class JumpFloorII {
    public static int jumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        int a = 1;
        for (int i = 1; i < target; i++) {
            a *= 2;
        }
        return a;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(jumpFloorII(i));
        }
    }
}
