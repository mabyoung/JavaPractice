package LeetCode.Simulation;

public class FinalValueAfterOperations {
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            switch (operation) {
                case "++X":
                case "X++":
                    result++;
                    break;
                case "--X":
                case "X--":
                    result--;
                    break;
            }
        }
        return result;
    }
}
