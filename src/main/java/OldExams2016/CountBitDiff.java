package OldExams2016;

public class CountBitDiff {
    /**
     * 获得两个整形二进制表达位数不同的数量
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public int countBitDiff(int m, int n) {
        int[] bitArrayM = this.toBitArray(m);
        int[] bitArrayN = this.toBitArray(n);
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitArrayM[i] != bitArrayN[i]) {
                result++;
            }
        }
        return result;
    }

    private int[] toBitArray(int decimal) {
        int[] bitArray = new int[32];
        int index = 0;
        while (decimal != 0) {
            bitArray[index++] = decimal % 2;
            decimal /= 2;
        }
        return bitArray;
    }

    public static void main(String[] args) {
        CountBitDiff countBitDiff = new CountBitDiff();
        System.out.println(countBitDiff.countBitDiff(1999,2299));
    }
}
