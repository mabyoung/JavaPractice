package LeetCode.Num;

public class LargestOddNumber {
    public String largestOddNumber(String num) {
        char[] chars = num.toCharArray();
        int index = chars.length-1;
        boolean flag = false;
        for (; index >= 0; index--) {
            if ((chars[index] - '0') % 2 != 0) {
                flag = true;
                break;
            }
        }
        if (!flag){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

}
