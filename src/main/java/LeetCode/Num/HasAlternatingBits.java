package LeetCode.Num;

public class HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            stringBuilder.append(n % 2);
            n /= 2;
        }
        char lastChar = ' ';
        for (int i = 0; i < stringBuilder.length(); i++) {
            char currentChar = stringBuilder.charAt(i);
            if (currentChar == lastChar) {
                return false;
            }
            lastChar = currentChar;
        }
        return true;
    }
}
