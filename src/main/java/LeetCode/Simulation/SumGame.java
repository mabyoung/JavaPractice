package LeetCode.Simulation;

public class SumGame {
    public boolean sumGame(String num) {
        char[] chars = num.toCharArray();
        int leftCount = 0;
        int rightCount = 0;
        long leftSum = 0;
        long rightSum = 0;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] == '?') {
                leftCount++;
            } else {
                leftSum += (chars[i] - '0');
            }
        }
        for (int i = chars.length / 2; i < chars.length; i++) {
            if (chars[i] == '?') {
                rightCount++;
            } else {
                rightSum += (chars[i] - '0');
            }
        }
        int minCount = Math.min(leftCount, rightCount);
        leftCount -= minCount;
        rightCount -= minCount;
        if (leftCount == 0 && rightCount == 0) {
            return leftSum != rightSum;
        } else if (leftCount == 0) {
            if (rightCount % 2 == 1) {
                return true;
            }
            leftSum -= rightSum;
            if (leftSum < 0) {
                return true;
            }
            if (leftSum == 9 * (rightCount / 2)){
                return false;
            }
            return true;
        } else {
            if (leftCount % 2 == 1) {
                return true;
            }
            rightSum -= leftSum;
            if (rightSum < 0) {
                return true;
            }
            if (rightSum == 9 * (leftCount / 2)){
                return false;
            }
            return true;
        }
    }
}
