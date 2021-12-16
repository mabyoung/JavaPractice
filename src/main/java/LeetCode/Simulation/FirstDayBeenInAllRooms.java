package LeetCode.Simulation;

import java.util.HashSet;
import java.util.Set;

public class FirstDayBeenInAllRooms {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        Set<Integer> visited = new HashSet<>();
        int n = nextVisit.length;
        int index = 0;
        boolean[] odd = new boolean[n];
        int days = -1;
        while (visited.size() < n) {
            days = (days + 1) % 1000000007;
            visited.add(index);
            if (odd[index]) {
                odd[index] = false;
                index = (index + 1) % n;
            } else {
                odd[index] = true;
                index = nextVisit[index];
            }
        }
        return days;
    }

    public static void main(String[] args) {
        FirstDayBeenInAllRooms firstDayBeenInAllRooms = new FirstDayBeenInAllRooms();
        firstDayBeenInAllRooms.firstDayBeenInAllRooms(new int[]{0,0});
    }
}
