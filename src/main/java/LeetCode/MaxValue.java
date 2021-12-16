package LeetCode;

public class MaxValue {
    public String maxValue(String n, int x) {
        if (n.startsWith("-")) {
            return "-" + minValue(n.substring(1), x);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if ((c - '0') < x) {
                stringBuilder.append(x).append(n.substring(i));
                return stringBuilder.toString();
            }
            stringBuilder.append(c);
        }
        stringBuilder.append(x);
        return stringBuilder.toString();
    }

    public String minValue(String n, int x) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if ((c - '0') > x) {
                stringBuilder.append(x).append(n.substring(i));
                return stringBuilder.toString();
            }
            stringBuilder.append(c);
        }
        stringBuilder.append(x);
        return stringBuilder.toString();
    }
}
