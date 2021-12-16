package LeetCode.Array;

public class NumberOfWeeks {
    public long numberOfWeeks(int[] milestones) {
        int longest = milestones[0];
        int longestIndex = 0;
        for (int i = 1; i < milestones.length; i++) {
            if (milestones[i] > longest) {
                longest = milestones[i];
                longestIndex = i;
            }
        }
        long rest = 0;
        for (int i = 0; i < milestones.length; i++) {
            if (i != longestIndex) {
                rest += milestones[i];
            }
        }
        if (longest <= rest + 1) {
            return longest + rest;
        } else {
            return rest * 2 + 1;
        }
    }


    public static void main(String[] args) {
        NumberOfWeeks numberOfWeeks = new NumberOfWeeks();
        long result = numberOfWeeks.numberOfWeeks(new int[]{8, 8, 2, 6});
        System.out.println(result);
    }
}
