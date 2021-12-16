package LeetCode.String;

import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (char item : jewels.toCharArray()) {
            jewelSet.add(item);
        }
        int result = 0;
        for (char item : stones.toCharArray()) {
            if (jewelSet.contains(item)) {
                result++;
            }
        }
        return result;
    }
}
