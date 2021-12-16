package LeetCode.String;

public class MakeFancyString {
    public String makeFancyString(String s) {
        if (s.length() <= 2) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        char lastLast = chars[0];
        char last = chars[1];
        stringBuilder.append(lastLast).append(last);
        for (int i = 2; i < chars.length; i++) {
            char now = chars[i];
            if (lastLast == last && last == now){
                continue;
            }
            stringBuilder.append(now);
            lastLast = last;
            last = now;
        }
        return stringBuilder.toString();
    }
}
