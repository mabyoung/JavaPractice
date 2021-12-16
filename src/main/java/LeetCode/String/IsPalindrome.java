package LeetCode.String;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            if (!isLegal(chars[left])) {
                left++;
            } else if (!isLegal(chars[right])) {
                right--;
            } else {
                if (chars[left++] != chars[right--]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isLegal(char item){
        if ('a' <= item && item <= 'z'){
            return true;
        }
        if ('0' <= item && item <= '9'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome("0P"));
    }
}
