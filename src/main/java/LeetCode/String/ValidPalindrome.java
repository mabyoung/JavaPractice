package LeetCode.String;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        lower = lower.replaceAll("[^a-z0-9]", "");
        lower = lower.replaceAll(" ", "");
        for (int i = 0; i < lower.length() / 2; i++) {
            if (lower.charAt(i) != lower.charAt(lower.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("1a2"));
    }
}
