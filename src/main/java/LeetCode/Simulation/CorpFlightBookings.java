package LeetCode.Simulation;

public class CorpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        int[] result = new int[n];
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            diff[first - 1] += seats;
            if (last < n) {
                diff[last] -= seats;
            }
        }
        result[0] = diff[0];
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }
}
