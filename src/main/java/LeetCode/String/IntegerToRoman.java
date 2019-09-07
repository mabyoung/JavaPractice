package LeetCode.String;

/**
 * 基本字符 对应的数字
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 * 相同的数字连写、所表示的数等于这些数字相加得到的数、如：Ⅲ=3；
 * 小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
 * 小的数字、（限于 Ⅰ、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
 * 正常使用时、连写的数字重复不得超过三次；
 * 在一个数的上面画一条横线、表示这个数扩大 1000 倍。
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < num / values[i]; j++) {
                result.append(romans[i]);
            }
            num = num % values[i];
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(9));
    }
}
