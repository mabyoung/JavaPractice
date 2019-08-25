package LeetCode.Complexity;

/**
 * 将给出的整数x翻转。
 * 例1:x=123，返回321
 * 例2:x=-123，返回-321
 * <p>
 * 你有思考过下面的这些问题么？
 * 如果整数的最后一位是0，那么输出应该是什么？比如10,100
 * 你注意到翻转后的整数可能溢出吗？假设输入是32位整数，则将翻转10000000003就会溢出，你该怎么处理这样的样例？
 * 抛出异常？这样做很好，但是如果不允许抛出异常呢？这样的话你必须重新设计函数（比如添加一个额外的参数）。
 */
public class ReverseInteger {
    public int reverse(int x) {
        String s = String.valueOf(x);
        if (s.charAt(0) == '-') {
            return -help(s.substring(1));
        }
        return help(s);
    }

    public int help(String s) {
        char[] chars = s.toCharArray();
        long result = 0;
        int weight = 1;
        for (int i = 0; i < s.length(); i++, weight *= 10) {
            result += weight * (chars[i] - '0');
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(100000003));
    }
}
