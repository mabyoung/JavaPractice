package LeetCode.String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (!set.contains(chars[left])) {
                left++;
            } else if (!set.contains(chars[right])) {
                right--;
            } else {
                char tmp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = tmp;
            }
        }
        return new String(chars);
    }
}
