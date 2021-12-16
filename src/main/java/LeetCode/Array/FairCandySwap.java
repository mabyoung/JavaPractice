package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        for (int aliceSize : aliceSizes) {
            aliceSum += aliceSize;
        }
        int bobSum = 0;
        Set<Integer> bobSet = new HashSet<>();
        for (int bobSize : bobSizes) {
            bobSum += bobSize;
            bobSet.add(bobSize);
        }
        int gap = (aliceSum - bobSum) / 2;
        int[] result = new int[2];
        for (int aliceSize : aliceSizes) {
            if (bobSet.contains(aliceSize - gap)) {
                result[0] = aliceSize;
                result[1] = aliceSize - gap;
                break;
            }
        }
        return result;
    }
}
