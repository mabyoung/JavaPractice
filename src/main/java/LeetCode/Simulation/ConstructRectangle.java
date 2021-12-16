package LeetCode.Simulation;

public class ConstructRectangle {
    public int[] constructRectangle(int area) {
        double sqrt = Math.sqrt(area);
        int a = (int) sqrt;
        while (area % a != 0) {
            a--;
        }
        int[] result = new int[2];
        result[0] = area / a;
        result[1] = a;
        return result;
    }
}
