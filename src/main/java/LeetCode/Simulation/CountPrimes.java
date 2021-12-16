package LeetCode.Simulation;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i; j <= n / 2; j++) {
                if (i * j >= n) {
                    break;
                }
                primes[i * j] = true;
            }
        }
        int result = 0;
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(499979));
    }
}
