package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class LongestObstacleCourseAtEachPosition {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] result = new int[n];
        List<Integer> list = new ArrayList<>();
        list.add(obstacles[0]);
        result[0] = 1;
        for (int i = 1; i < obstacles.length; i++) {
            int index = getIndex(list, obstacles[i]);
            if (index == list.size() - 1) {
                list.add(obstacles[i]);
            } else {
                list.set(index + 1, obstacles[i]);
            }
            result[i] = index + 2;
        }
        return result;
    }

    public int getIndex(List<Integer> list, int target) {
        if (target < list.get(0)) {
            return -1;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (list.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        LongestObstacleCourseAtEachPosition longestObstacleCourseAtEachPosition = new LongestObstacleCourseAtEachPosition();
        int[] result = longestObstacleCourseAtEachPosition.longestObstacleCourseAtEachPosition(new int[]{2, 2, 1});
        for (int item : result) {
            System.out.println(item);
        }
    }
}
