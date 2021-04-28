package CrackingTheCodingInterview.Basis;

/**
 * 请编写一个方法，输出0到n(包括n)中数字2出现了几次。
 * 给定一个正整数n，请返回0到n的数字中2出现了几次。
 */
public class Count2 {
    public int countNumberOf2s(int n) {
        int result = 0;
        int position = 1;
        int high = n / position;
        int low = n % position;
        do {
            if (high % 10 < 2) {
                result += (high / 10) * position;
            } else if (high % 10 == 2) {
                result += (high / 10) * position + low + 1;
            } else {
                result += (high / 10 + 1) * position;
            }
            position *= 10;
            high = n / position;
            low = n % position;
        } while (high > 0);
        return result;
    }

    public static void main(String[] args) {
        Count2 count2 = new Count2();
        System.out.println(count2.countNumberOf2s(22));
    }
}
