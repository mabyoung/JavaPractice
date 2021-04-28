package CrackingTheCodingInterview.Recursive;

/**
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 */
public class GoUpstairs {
    public int countWays(int n) {
        int n1 = 1;
        int n2 = 2;
        int n3 = 4;
        if (n == 1) {
            return n1;
        } else if (n == 2) {
            return n2;
        } else if (n == 3) {
            return n3;
        } else {
            for (int i = 3; i < n; i++) {
                int tmp = ((n1 + n2) % 1000000007 + n3) % 1000000007;
                n1 = n2;
                n2 = n3;
                n3 = tmp;
            }
        }
        return n3;
    }

    public static void main(String[] args) {
        GoUpstairs goUpstairs = new GoUpstairs();
        System.out.println(goUpstairs.countWays(36196));
    }
}
