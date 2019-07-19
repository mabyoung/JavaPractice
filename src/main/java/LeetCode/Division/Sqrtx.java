package LeetCode.Division;

public class Sqrtx {
    public int sqrt(int x) {
        int odd = 1;
        int count = 0;
        while (x >= 0) {
            x -= odd;
            odd += 2;
            count++;
        }
        return count - 1;
    }

    public static void main(String[] args) {
        Sqrtx sqrtx = new Sqrtx();
        System.out.println(sqrtx.sqrt(2));
    }
}
