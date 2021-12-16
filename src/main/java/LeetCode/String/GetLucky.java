package LeetCode.String;

public class GetLucky {
    public int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            stringBuilder.append(c - 'a' + 1);
        }
        String str = stringBuilder.toString();
        for (int i = 0; i < k; i++) {
            str = getSpecialSum(str);
        }
        return Integer.parseInt(str);
    }

    public String getSpecialSum(String str) {
        long result = 0;
        for (char c : str.toCharArray()) {
            result += (c - '0');
        }
        return String.valueOf(result);
    }
}
