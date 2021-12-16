package LeetCode.Num;

public class AddDigits {
    public int addDigits(int num) {
        String str = String.valueOf(num);
        int sum = 0;
        for (char item : str.toCharArray()) {
            sum += item - '0';
        }
        if (sum >= 10) {
            return addDigits(sum);
        }
        return sum;
    }
}
