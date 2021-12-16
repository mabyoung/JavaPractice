package LeetCode.Array;

public class AddRungs {
    public int addRungs(int[] rungs, int dist) {
        int now = 0;
        int result = 0;
        for (int rung : rungs) {
            int num = (int)Math.ceil((rung - now) / (double)dist);
            if (num > 1) {
                result = result + num - 1;
            }
            now = rung;
        }
        return result;
    }
}
