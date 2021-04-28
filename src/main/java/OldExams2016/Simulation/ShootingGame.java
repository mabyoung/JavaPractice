package OldExams2016.Simulation;

import java.util.Scanner;

public class ShootingGame {
    public static int shooting(int p, int[] ballNum) {
        int[] hoop = new int[p];
        for (int i = 0; i < ballNum.length; i++) {
            if (hoop[ballNum[i] % p] == 1) {
                return i + 1;
            } else {
                hoop[ballNum[i] % p] = 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int n = scanner.nextInt();
            int[] ballNum = new int[n];
            for (int i = 0; i < n; i++) {
                ballNum[i] = scanner.nextInt();
            }
            System.out.println(shooting(p, ballNum));
        }
    }
}
