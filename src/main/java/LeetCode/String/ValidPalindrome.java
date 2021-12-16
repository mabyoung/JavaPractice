package LeetCode.String;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s.substring(left, right)) || isPalindrome(s.substring(left + 1, right + 1));
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean result = validPalindrome.validPalindrome("abc");
        System.out.println(result);
    }
}
