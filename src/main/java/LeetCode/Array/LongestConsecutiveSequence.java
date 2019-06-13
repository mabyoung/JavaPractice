package LeetCode.Array;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int item : num) {
            set.add(item);
        }
        int max = 0;
        for (int item : num) {
            int current = biggerNum(set, item + 1) + smallerNum(set, item - 1);
            if (current > max) {
                max = current;
            }
        }
        return max + 1;
    }

    public int biggerNum(HashSet<Integer> set, int num) {
        if (set.contains(num)) {
            set.remove(num);
            return 1 + biggerNum(set, num + 1);
        } else {
            return 0;
        }
    }

    public int smallerNum(HashSet<Integer> set, int num) {
        if (set.contains(num)) {
            set.remove(num);
            return 1 + smallerNum(set, num - 1);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int result = longestConsecutiveSequence.longestConsecutive(null);
        System.out.println(result);
    }
}
