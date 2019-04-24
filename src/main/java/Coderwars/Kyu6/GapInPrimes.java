package Coderwars.Kyu6;

public class GapInPrimes {
    public static boolean isPrime(long num){
        if (num <= 3){
            return num > 1;
        }
        if (num % 6 != 1 && num % 6 != 5){
            return false;
        }
        for (long i = 5;i <= Math.sqrt(num);i=i+6){
            if (num % i == 0 || num % (i+2) == 0){
                return false;
            }
        }
        return true;
    }

    public static long[] gap(int g, long m, long n){
        long[] result = new long[2];
        for(long i = m ;i+g<=n;i++){
            if (i+g<=n && isPrime(i) && isPrime(i+g)){
                result[0] = i;
                result[1] = i+g;
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        long[] gap = gap(2, 100, 110);
        for (long l : gap) {
            System.out.println(l);
        }
    }
}
