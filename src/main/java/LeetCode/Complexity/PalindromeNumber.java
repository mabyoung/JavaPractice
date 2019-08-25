package LeetCode.Complexity;

/**
 * 在只使用常数空间的条件下判断一个整数是否是回文
 * 提示：
 * 负整数可以是回文吗？（比如-1）
 * 如果你在考虑将数字转化为字符串的话，请注意一下不能使用额外空间的限制
 * 你可以将整数翻转。但是，如果你做过题目“Reverse Integer”，你会知道将整数翻转可能会出现溢出的情况，你怎么处理这个问题？
 * 这道题有更具普遍性的解法。
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reserve = 0;
        for (int y = x; y != 0; y /= 10) {
            reserve = reserve * 10 + y % 10;
        }
        return reserve == x;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(-92));
    }
}
