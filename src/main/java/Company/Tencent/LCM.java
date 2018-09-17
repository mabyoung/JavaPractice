package Company.Tencent;

import java.util.*;

/**
 * Created by rui on 2018/9/16.
 */
public class LCM {
    public static int gcd(int n1, int n2) {
        int gcd = 0;
        if (n1 < n2) {
            n1 = n1 + n2;
            n2 = n1 - n2;
            n1 = n1 - n2;
        }
        if (n1 % n2 == 0) {
            gcd = n2;
        }
        while (n1 % n2 > 0) {
            n1 = n1 % n2;
            if (n1 < n2) {
                n1 = n1 + n2;
                n2 = n1 - n2;
                n1 = n1 - n2;
            }
            if (n1 % n2 == 0) {
                gcd = n2;
            }
        }
        return gcd;
    }

    public static int lcm(int n1, int n2) {
        return n1 * n2 / gcd(n1, n2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> set = new HashSet<>(n);
        for (int i = 2; i <= n; i++) {
            set.add(i);
        }
        for (int i = n + 1; ; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer item : set) {
                tmp.add(item);
            }
            set = new HashSet<>();
            for (Integer item : tmp) {
                int gcd = gcd(item, i);
                if (item/gcd != 1){
                    set.add(item/gcd);
                }
            }
            if (set.size() ==0){
                System.out.println(i);
                return;
            }
        }
    }
}
