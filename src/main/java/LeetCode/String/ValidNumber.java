package LeetCode.String;

/**
 * 判断给出的字符串是否是数字
 * 一些例子：
 * "0"=>true
 * " 0.1 "=>true
 * "abc"=>false
 * "1 a"=>false
 * "2e10"=>true
 * 注意：
 * 这道题故意陈述的比较模糊，在实现一个需求之前，你应该预先收集所有的要求。
 * 设置4个标志，分别是
 * boolean pointSeen = false;//是否出现过小数点“.”
 * boolean eSeen = false;//是否出现过指数标志“e”
 * boolean numberSeen = false;//是否出现过数字
 * boolean numberAfterE = false;//e后面是否有数字
 * 进行循环s.charAt(i)：
 * 1.如果属于[0,9]，把numberSeen设为true
 * 2.如果是‘.’，必须之前没有遇到'.'和'e'
 * 3.如果是'e'，必须之前没有遇到过'e'
 * 4.如果是'+'或者'-',当前i必须是0，或者i-1上的字符是e
 * 5.其他情况返回false
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberSeen = true;
                if (eSeen){
                    numberAfterE = true;
                }
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (eSeen && !numberAfterE){
            return false;
        }
        return numberSeen;
    }

    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();
        System.out.println(validNumber.isNumber("0"));
        System.out.println(validNumber.isNumber("0.1"));
        System.out.println(validNumber.isNumber("abc"));
        System.out.println(validNumber.isNumber("1 a"));
        System.out.println(validNumber.isNumber("2e10"));
        System.out.println(validNumber.isNumber("e9"));
    }
}
