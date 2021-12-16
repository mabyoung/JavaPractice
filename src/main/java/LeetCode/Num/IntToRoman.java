package LeetCode.Num;

import java.util.HashMap;
import java.util.Map;

/**
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 */
public class IntToRoman {
    public class RomanCode {
        String code;
        int value;

        public RomanCode(String code, int value) {
            this.code = code;
            this.value = value;
        }
    }

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        RomanCode[] romanCodes = new RomanCode[]{new RomanCode("M", 1000), new RomanCode("CM", 900),
                new RomanCode("D", 500), new RomanCode("CD", 400), new RomanCode("C", 100),
                new RomanCode("XC", 90),new RomanCode("L", 50), new RomanCode("XL", 40),
                new RomanCode("X", 10),new RomanCode("IX", 9), new RomanCode("V", 5),
                new RomanCode("IV", 4),new RomanCode("I", 1)};
        for (RomanCode romanCode : romanCodes) {
            for (int i = 0; i < num / romanCode.value; i++) {
                stringBuilder.append(romanCode.code);
            }
            num %= romanCode.value;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(1994));
    }
}
