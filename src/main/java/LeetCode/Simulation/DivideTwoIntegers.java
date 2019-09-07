package LeetCode.Simulation;

/**
 * 在不使用乘法运算符，除法运算符和取余运算符的情况下对两个数进行相除操作
 */
public class DivideTwoIntegers {
    public int divide1(int dividend, int divisor) {
        long nd1 = Math.abs((long) dividend);
        long nd2 = Math.abs((long) divisor);
        int result = 0;
        for (long a = 1, b = nd2; nd1 >= nd2; ) {
            if (nd1 < b << 1) {
                result += a;
                a = 1;
                nd1 -= b;
                b = nd2;
            } else {
                a <<= 1;
                b <<= 1;
            }
        }
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            return -result;
        }
        return result;
    }

    public int add(int a, int b) {
        int sum = a;
        int arr = b;// 表示进位
        while (arr != 0) {
            sum = a ^ b;
            arr = (a & b) << 1;
            a = sum;
            b = arr;
        }
        return sum;
    }

    public int minus(int a, int b) {
        // b为减数,先变成负数
        b = add(~b, 1);
        return add(a, b);
    }

    public int multi(int a, int b) {
        // b为乘数
        for (int i = 0; i < b - 1; i++) {
            a = add(a, a);
        }
        return a;
    }

    public int divide(int dividend, int divisor) {
        // a被除树，b为除数
        int a = dividend;
        int b = divisor;
        if (a == 1)
            return 0;
        if (b == 0)
            try {
                throw new Exception("被除数不能为0！");
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        int result = 0;
        if (a > 0 && b > 0) {
            while (a > 0) {
                a = minus(a, b);
                if (a >= 0)
                    result++;
            }
            return result;
        } else if (a < 0 && b > 0) {
            a = add(~a, 1);
            return add(~divide(a, b), 1);// 结果变为负号
        } else if (a > 0) {
            b = add(~b, 1);
            return add(~divide(a, b), 1);
        } else if (a < 0) {
            a = add(~a, 1);
            b = add(~b, 1);
            return divide(a, b);
        }
        return result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(1, -1));
    }
}
