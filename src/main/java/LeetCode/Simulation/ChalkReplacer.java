package LeetCode.Simulation;

public class ChalkReplacer {
    public int chalkReplacer(int[] chalk, int k) {
        long oneCycle = 0;
        for (int num : chalk) {
            oneCycle += num;
        }
        long rest = k % oneCycle;
        for (int i = 0; i < chalk.length; i++) {
            if (rest < chalk[i]) {
                return i;
            }
            rest -= chalk[i];
        }
        return 0;
    }
}
