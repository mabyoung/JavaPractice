package CrackingTheCodingInterview.Basis;

/**
 * 编写一个函数，确定需要改变几个位，才能将整数A转变成整数B。
 * 给定两个整数int A，int B。请返回需要改变的数位个数。
 */
public class Transform {
    public int calcCost(int A, int B) {
        int result = 0;
        while (A != 0 && B != 0) {
            if (A % 2 != B % 2) {
                result++;
            }
            A /= 2;
            B /= 2;
        }
        while (A != 0) {
            if (A % 2 != 0) {
                result++;
            }
            A /= 2;
        }
        while (B != 0) {
            if (B % 2 != 0) {
                result++;
            }
            B /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Transform transform = new Transform();
        int result = transform.calcCost(68794, 15646);
        System.out.println(result);
    }
}
