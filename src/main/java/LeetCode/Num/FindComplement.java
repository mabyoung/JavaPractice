package LeetCode.Num;

public class FindComplement {
    public int findComplement(int num) {
        String binary = decimal2Binary(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                stringBuilder.append('1');
            } else {
                stringBuilder.append('0');
            }
        }
        return binary2Decimal(stringBuilder.toString());
    }

    public String decimal2Binary(int decimal) {
        StringBuilder stringBuilder = new StringBuilder();
        while (decimal > 0) {
            stringBuilder.append(decimal % 2);
            decimal /= 2;
        }
        return stringBuilder.reverse().toString();
    }

    public int binary2Decimal(String binary) {
        int result = 0;
        int index = binary.length() - 1;
        int weight = 1;
        while (index >= 0) {
            result += (binary.charAt(index) - '0') * weight;
            index--;
            weight *= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        FindComplement findComplement = new FindComplement();
        System.out.println(findComplement.findComplement(5));
    }
}
