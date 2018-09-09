package Company.IFLYTEK;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rui on 2018/9/7.
 */
public class Killer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        int count = 0;
        while (true) {
            boolean flag = true;
            for (int i = list.size() - 1; i > 0; i--) {
                if (list.get(i - 1) > list.get(i)) {
                    list.remove(i);
                    flag = false;
                }
            }
            count++;
            if (flag) {
                System.out.println(count - 1);
                return;
            }
        }
    }
}
