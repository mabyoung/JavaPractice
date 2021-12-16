package LeetCode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : deck) {
            map.merge(item, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>(map.values());
        return gcd(list) >= 2;
    }

    public int gcd(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = gcd(result, list.get(i));
        }
        return result;
    }

    public int gcd(int a, int b) {
        if (a > b) {
            return gcd(b, a);
        }
        if (a == 0) {
            return b;
        }
        return gcd(a, b % a);
    }

    public static void main(String[] args) {
        HasGroupsSizeX hasGroupsSizeX = new HasGroupsSizeX();
        System.out.println(hasGroupsSizeX.hasGroupsSizeX(new int[]{1,1,2,2,2,2}));
    }
}
