package LeetCode.String;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int index = isOk(chars, i);
            if (index != -1) {
                result += (index - i) / 2;
                i += ((index - i) / 2 - 1);
            }
        }
        return result;
    }

    public int isOk(char[] chars, int begin) {
        char c = chars[begin];
        int count = 1;
        int index = begin + 1;
        boolean flag = true;
        while (index < chars.length) {
            if (count == 0) {
                break;
            }
            if (chars[index] == c && flag) {
                count++;
            } else if (chars[index] == c && !flag) {
                break;
            } else if (chars[index] != c) {
                flag = false;
                count--;
            }
            index++;
        }
        return count == 0 ? index : -1;
    }

    public static void main(String[] args) {
        CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();
        int result = countBinarySubstrings.countBinarySubstrings("00110011");
        System.out.println(result);
    }
}
