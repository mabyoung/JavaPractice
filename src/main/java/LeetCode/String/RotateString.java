package LeetCode.String;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i <= s.length(); i++) {
            if (s.equals(goal)) {
                return true;
            }
            s = s.substring(1) + s.substring(0, 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(s.substring(1) + s.substring(0, 1));
    }
}
