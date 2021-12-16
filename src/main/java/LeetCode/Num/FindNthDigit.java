package LeetCode.Num;

public class FindNthDigit {
    public int findNthDigit(int n) {
        int i = 1;
        while (true) {
            int sum = (int) (i * Math.pow(10, i));
            if (n < sum) {
                break;
            }
            n -= sum;
            i++;
        }
        long result = (long) Math.pow(10, i - 1);
        result += (n / i);
        return String.valueOf(result).charAt(n % i)-'0';
    }

    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(findNthDigit.findNthDigit(200));
    }
}
