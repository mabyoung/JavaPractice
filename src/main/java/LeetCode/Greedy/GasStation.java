package LeetCode.Greedy;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
 *
 * You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length <= 0 || cost.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = 0;
        int currentGas = gas[0] - cost[0];
        while ((end + 1) % gas.length != start) {
            if (currentGas < 0) {
                start = (start - 1 + gas.length) % gas.length;
                currentGas += gas[start] - cost[start];
            } else {
                end = (end + 1) % gas.length;
                currentGas += gas[end] - cost[end];
            }
        }
        return currentGas < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2};
        int[] cost = {2, 1};
        GasStation gasStation = new GasStation();
        gasStation.canCompleteCircuit(gas, cost);
    }
}
