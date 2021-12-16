package LeetCode.Num;

public class CountPrimeSetBits {
    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                result++;
            }
        }
        return result;
    }

    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountPrimeSetBits countPrimeSetBits = new CountPrimeSetBits();
        countPrimeSetBits.countPrimeSetBits(6, 10);
    }
}
