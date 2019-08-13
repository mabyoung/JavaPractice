package LeetCode.String;

public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = getNext(result);
        }
        return result;
    }

    private String getNext(String num) {
        if (num == null || num.length() == 0) {
            return null;
        }
        int count = 1;
        char[] chars = num.toCharArray();
        char lastChar = chars[0];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == lastChar) {
                count++;
            } else {
                stringBuilder.append(count).append(lastChar);
                count = 1;
            }
            lastChar = chars[i];
        }
        stringBuilder.append(count).append(lastChar);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        String result = countAndSay.countAndSay(20);
        System.out.println(result);
    }
}
