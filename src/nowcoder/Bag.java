package nowcoder;

import java.util.Scanner;

public class Bag {
    private static Treasure[] treasures;
    private static int n;
    private static int capacity;
    private static int bestValue;
    private static int[][] bestValues;

    private static void solve() {
        for (int j = 0; j <= capacity; j++) {
            for (int i = 0; i <= n; i++) {
                if (i == 0 || j == 0) {
                    bestValues[i][j] = 0;
                } else {
                    if (j < treasures[i - 1].getWeight()) {
                        bestValues[i][j] = bestValues[i - 1][j];
                    } else {
                        int weight = treasures[i - 1].getWeight();
                        int value = treasures[i - 1].getValue();
                        bestValues[i][j] = Math.max(bestValues[i - 1][j], value + bestValues[i - 1][j - weight]);
                    }
                }
            }
        }
        bestValue = bestValues[n][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(",");
        n = split.length;
        treasures = new Treasure[n];
        for (int i = 0; i < n; i++) {
            treasures[i] = new Treasure();
            treasures[i].setValue(Integer.parseInt(split[i]));
        }
        split = scanner.nextLine().trim().split(",");
        for (int i = 0; i < n; i++) {
            treasures[i].setWeight(Integer.parseInt(split[i]));
        }
        capacity = Integer.parseInt(scanner.nextLine().trim());
        bestValues = new int[n + 1][capacity + 1];
        solve();
        System.out.println(bestValue);
    }
}

class Treasure {
    private int weight;
    private int value;

    int getWeight() {
        return weight;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

}
