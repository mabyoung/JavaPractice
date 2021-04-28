package Company.ABC;

import java.util.Scanner;

/**
 * 火星人用三进制数表示数据 @，＄， &分别表示0，1，2，现在输入一个十进制数，输出为三进制数
 */
public class ToTernaryNum {
    public static String toTernaryNum(int decimalNum){
        StringBuilder result = new StringBuilder();
        while(decimalNum>0) {
            int mod = decimalNum % 3;
            decimalNum = decimalNum / 3;
            switch (mod) {
                case 0:
                    result.insert(0, "@");
                    break;
                case 1:
                    result.insert(0, "$");
                    break;
                case 2:
                    result.insert(0, "&");
                    break;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine().trim();
            System.out.println(toTernaryNum(Integer.parseInt(input)));
        }
    }
}
