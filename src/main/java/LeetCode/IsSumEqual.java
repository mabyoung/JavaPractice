package LeetCode;

public class IsSumEqual {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        char[] charsA = revert(firstWord);
        char[] charsB = revert(secondWord);
        char[] charsC = revert(targetWord);
        int carry = 0;
        for (int i = 0; i < 10; i++) {
            int a = charsA.length > i ? (charsA[i] - 'a') : 0;
            int b = charsB.length > i ? (charsB[i] - 'a') : 0;
            int c = charsC.length > i ? (charsC[i] - 'a') : 0;
            int sum = a + b + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            if (sum != c) {
                return false;
            }
        }
        return true;
    }

    public char[] revert(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = tmp;
        }
        return chars;
    }
}
