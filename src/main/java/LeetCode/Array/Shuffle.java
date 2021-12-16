package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shuffle {
    public int[] origin;

    public Shuffle(int[] nums) {
        origin = nums;
    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        int n = origin.length;
        int[] result = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int item : origin) {
            list.add(item);
        }
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int index = random.nextInt(list.size());
            result[i] = list.get(index);
            list.remove(index);
        }
        return result;
    }
}
