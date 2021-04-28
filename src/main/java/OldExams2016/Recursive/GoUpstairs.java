package OldExams2016.Recursive;

public class GoUpstairs {
    public int countWays(int n) {
        if (n <= 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else {
            int a = 1;
            int b = 2;
            for (int i = 3; i < n; i++) {
                int tmp = b;
                b = (a + b) % 1000000007;
                a = tmp;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        GoUpstairs goUpstairs = new GoUpstairs();
        System.out.println(goUpstairs.countWays(5));
    }
}
