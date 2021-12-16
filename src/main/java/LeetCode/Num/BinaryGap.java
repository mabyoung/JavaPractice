package LeetCode.Num;

public class BinaryGap {
    public int binaryGap(int n) {
        String binary = toBinary(n);
        int result = 0;
        Integer lastIndex = null;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                if (lastIndex != null) {
                    result = Math.max(result, i - lastIndex);
                }
                lastIndex = i;
            }
        }
        return result;
    }

    public String toBinary(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            stringBuilder.append(n % 2);
            n /= 2;
        }
        return stringBuilder.reverse().toString();
    }


}
