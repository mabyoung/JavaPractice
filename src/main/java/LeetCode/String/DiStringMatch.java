package LeetCode.String;

public class DiStringMatch {
    public int[] diStringMatch(String s) {
        int left = 0;
        int right = 0;
        int[] result = new int[s.length() + 1];
        int index = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                result[index++] = ++right;
            } else {
                result[index++] = --left;
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] - left;
        }
        return result;
    }

    public static void main(String[] args) {
        DiStringMatch diStringMatch = new DiStringMatch();
        int[] result = diStringMatch.diStringMatch("IDID");
        for (int item : result) {
            System.out.println(item);
        }
    }
}
