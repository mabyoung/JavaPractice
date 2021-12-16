package LeetCode.Simulation;

import java.util.Arrays;

public class NumRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int result = 0;
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                right--;
            } else {
                right--;
                left++;
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        NumRescueBoats numRescueBoats = new NumRescueBoats();
        int result = numRescueBoats.numRescueBoats(new int[]{2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10}, 50);
        System.out.println(result);
    }
}
