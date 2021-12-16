package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int item : candyType) {
            set.add(item);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
