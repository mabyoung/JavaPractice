package CrackingTheCodingInterview.Basis;

/**
 * 请编写一个方法，实现整数的乘法、减法和除法运算(这里的除指整除)。只允许使用加号。
 * 给定两个正整数int a,int b,同时给定一个int type代表运算的类型，1为求a ＊ b，0为求a ／ b，-1为求a － b。请返回计算的结果，保证数据合法且结果一定在int范围内。
 */
public class AddSubstitution {
    public int calc(int a, int b, int type) {
        switch (type) {
            case 1:
                return multiply(a, b);
            case 0:
                return division(a, b);
            case -1:
                return sub(a, b);
        }
        throw new RuntimeException("预料之外的type");
    }

    private int multiply(int a, int b) {
        int result = 0;
        for (int i = 0; i < a; i++) {
            result += b;
        }
        return result;
    }

    private int division(int a, int b) {
        for (int i = 0; i < a; i++) {
            if (multiply(i, b) <= a && multiply(i + 1, b) >= a) {
                return i;
            }
        }
        throw new RuntimeException("不可能到达的代码");
    }

    private int sub(int a, int b) {
        return a + multiply(b, -1);
    }
}
