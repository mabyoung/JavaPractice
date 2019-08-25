package LeetCode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串"PAYPALISHIRING"写成3行的Z字形的样式如下：
 * <p>
 * P   A   H   N↵
 * A P L S I I G↵
 * Y   I   R
 * <p>
 * 按行读这个Z字形图案应该是 "PAHNAPLSIIGYIR"
 * <p>
 * 请编写代码完成将字符串转化为指定行数的Z字形字符串：
 * <p>
 * string convert(string text, int nRows);
 * <p>
 * convert("PAYPALISHIRING", 3)应该返回"PAHNAPLSIIGYIR"
 */
public class ZigzagConversion {
    public String convert(String s, int nRows) {
        StringBuilder[] stringBuilders = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < nRows && index < s.length(); i++) {
                stringBuilders[i].append(s.charAt(index++));
            }
            for (int i = nRows - 2; i >= 1 && index < s.length(); i--) {
                stringBuilders[i].append(s.charAt(index++));
            }
        }
        for (int i = 1; i < nRows; i++) {
            stringBuilders[0].append(stringBuilders[i]);
        }
        return stringBuilders[0].toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        String result = zigzagConversion.convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }
}
