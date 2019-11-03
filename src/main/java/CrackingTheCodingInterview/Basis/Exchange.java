package CrackingTheCodingInterview.Basis;

/**
 * 请编写程序交换一个数的二进制的奇数位和偶数位。（使用越少的指令越好）
 * 给定一个int x，请返回交换后的数int。
 */
public class Exchange {
    public int exchangeOddEven(int x) {
        int justOdd = x & 0x55555555;
        int justEven = x & 0xAAAAAAAA;
        return (justOdd << 1) + (justEven >> 1);
    }

    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        int result = exchange.exchangeOddEven(10);
        System.out.println(result);
    }
}
