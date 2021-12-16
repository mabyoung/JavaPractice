package LeetCode.Simulation;

public class MinimumPerimeter {
    public long minimumPerimeter(long neededApples) {
        long apples = 0;
        int sideLength = 0;
        while (apples < neededApples) {
            sideLength++;
            apples += getSquareApples(sideLength);
        }
        return sideLength * 8;
    }

    public long getSquareApples(long sideLength) {
        return 12 * sideLength * sideLength;
    }

    public static void main(String[] args) {
        MinimumPerimeter minimumPerimeter = new MinimumPerimeter();
        for (int i = 1; i < 100; i++) {
            System.out.println(minimumPerimeter.getSquareApples(i));
        }
    }
}
