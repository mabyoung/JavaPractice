package LeetCode.Simulation;

public class CircleGame {
    public int circleGame(int[][] toys, int[][] circles, int r) {
        int result = 0;
        for (int i = 0; i < toys.length; i++) {
            if (toys[i][2] > r) {
                continue;
            }
            for (int j = 0; j < circles.length; j++) {
                if (isInCircle(toys[i], circles[j], r)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public boolean isInCircle(int[] toy, int[] circle, int r) {
        int toyA = toy[0];
        int toyB = toy[1];
        int toyR = toy[2];
        int circleA = circle[0];
        int circleB = circle[1];
        double dis = Math.sqrt((toyA - circleA) * (toyA - circleA) + (toyB - circleB) * (toyB - circleB));
        return toyR + dis <= r;
    }
}
