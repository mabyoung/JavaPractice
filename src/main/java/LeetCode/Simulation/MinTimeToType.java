package LeetCode.Simulation;

public class MinTimeToType {
    public int minTimeToType(String word) {
        int result = word.length();
        char[] chars = word.toCharArray();
        char last = 'a';
        for (int i = 0; i < chars.length; i++) {
            int now = chars[i];
            int a = Math.abs(last - chars[i]);
            int b;
            if (last > now) {
                b = Math.abs(now - 'a' + 'z' - last + 1);
            } else {
                b = Math.abs(last - 'a' + 'z' - now + 1);
            }
            result += Math.min(a, b);
            last = chars[i];
        }
        return result;
    }

    public static void main(String[] args) {
        MinTimeToType minTimeToType = new MinTimeToType();
        System.out.println(minTimeToType.minTimeToType("zjpc"));
    }
}
