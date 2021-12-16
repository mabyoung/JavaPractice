package LeetCode.Simulation;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int num5 = 0;
        int num10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                num5++;
            } else if (bill == 10) {
                num5--;
                num10++;
            } else {
                if (num10 > 0) {
                    num10--;
                    num5--;
                } else {
                    num5 -= 3;
                }
            }
            if (num5 < 0) {
                return false;
            }
        }
        return true;
    }
}
