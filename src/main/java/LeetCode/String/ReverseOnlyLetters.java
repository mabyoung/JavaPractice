package LeetCode.String;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (!isLetter(chars[left])) {
                left++;
            } else if (!isLetter(chars[right])) {
                right--;
            } else {
                char tmp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = tmp;
            }
        }
        return new String(chars);
    }

    public boolean isLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
