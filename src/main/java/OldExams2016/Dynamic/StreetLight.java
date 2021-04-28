package OldExams2016.Dynamic;

import java.util.*;

public class StreetLight {
    public static double getMinLightingDistance(int streetLength, int[] positions) {
        Arrays.sort(positions);
        int maxGap = 0;
        for (int i = 0; i <= positions.length; i++) {
            if (i == 0) {
                maxGap = Math.max(maxGap, 2 * positions[0]);
            } else if (i == positions.length) {
                maxGap = Math.max(maxGap, 2 * (streetLength - positions[i - 1]));
            } else {
                maxGap = Math.max(maxGap, positions[i] - positions[i - 1]);
            }
        }
        return maxGap / 2.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int streetLength = scanner.nextInt();
            int[] positions = new int[n];
            for (int i = 0; i < n; i++) {
                positions[i] = scanner.nextInt();
            }
            System.out.printf("%.2f\n", getMinLightingDistance(streetLength, positions));
        }
    }
}
