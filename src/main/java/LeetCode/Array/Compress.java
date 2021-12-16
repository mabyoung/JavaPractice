package LeetCode.Array;

public class Compress {
    public int compress(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        char last = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == last) {
                count++;
            } else {
                stringBuilder.append(last);
                if (count > 1) {
                    stringBuilder.append(count);
                }
                last = chars[i];
                count = 1;
            }
        }
        stringBuilder.append(last);
        if (count > 1) {
            stringBuilder.append(count);
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            chars[i] = stringBuilder.charAt(i);
        }
        return stringBuilder.length();
    }

    public static void main(String[] args) {
        Compress compress = new Compress();
        System.out.println(compress.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
