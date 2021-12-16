package LeetCode.Num;

public class IsThree {
    public boolean isThree(int n) {
        if (n == 1){
            return false;
        }

        int sqrt = (int) Math.sqrt(n);
        return isP(sqrt) && sqrt * sqrt == n;
    }

    public boolean isP(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsThree isThree = new IsThree();
        System.out.println(isThree.isThree(1));
    }

}
