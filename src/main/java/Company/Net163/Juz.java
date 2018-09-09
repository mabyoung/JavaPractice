package Company.Net163;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by rui on 2018/9/8.
 */
public class Juz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            HashMap<Integer, Integer> mapA = new HashMap<>();
            HashMap<Integer, Integer> mapB = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (i == 0) {
                    mapA.put(a, 1);
                    mapB.put(b, 1);
                } else {
                    if (mapB.containsKey(a)) {
                        Integer value = mapB.get(a);
                        if (value == 1) {
                            mapB.remove(a);
                        } else {
                            mapB.put(a, value - 1);
                        }
                    }
                    if (mapA.containsKey(b)) {
                        Integer value = mapA.get(b);
                        if (value == 1) {
                            mapA.remove(b);
                        } else {
                            mapA.put(b, value - 1);
                        }
                    }
                    mapA.put(a, 1);
                    mapB.put(b, 1);
                }
            }
            if (mapA.size() > 1) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
}
