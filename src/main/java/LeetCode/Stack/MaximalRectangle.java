package LeetCode.Stack;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int[] height = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            Stack<Integer> stack = new Stack<>();
            for (int item : height) {
                int count = 0;
                while (!stack.isEmpty() && item < stack.peek()) {
                    result = Math.max(stack.pop() * ++count, result);
                }
                for (int index = 0; index < count; index++) {
                    stack.push(item);
                }
                stack.push(item);
            }
            int count = 0;
            while (!stack.isEmpty()) {
                result = Math.max(stack.pop() * ++count, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char [][] c = new char[][]{{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},
                {'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}};
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        int result = maximalRectangle.maximalRectangle(c);
        System.out.println(result);
    }
}
