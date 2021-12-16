package LeetCode;

public class CheckZeroOnes {
    public boolean checkZeroOnes(String s) {
        char[] chars = s.toCharArray();
        char lastChar = ' ';
        int zeroNum = 0;
        int oneNum = 0;
        int maxZeroNum = 0;
        int maxOneNum = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                zeroNum = 0;
                if (lastChar == '1') {
                    oneNum++;
                } else {
                    oneNum = 1;
                    lastChar = '1';
                }
                maxOneNum = Math.max(oneNum, maxOneNum);
            } else {
                oneNum = 0;
                if (lastChar == '0') {
                    zeroNum++;
                } else {
                    zeroNum = 1;
                    lastChar = '0';
                }
                maxZeroNum = Math.max(zeroNum, maxZeroNum);
            }
        }
        return maxOneNum > maxZeroNum;
    }

    public static void main(String[] args) {
        CheckZeroOnes checkZeroOnes = new CheckZeroOnes();
        boolean result = checkZeroOnes.checkZeroOnes("111000");
        System.out.println(result);
    }
}
