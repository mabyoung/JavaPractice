package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", n);
        return result;
    }

    public void dfs(List<String> result, String current, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        if (isOk(current + "(", n)) {
            dfs(result, current + "(", n);
        }
        if (isOk(current + ")", n)) {
            dfs(result, current + ")", n);
        }
    }

    public boolean isOk(String current, int n) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char item : current.toCharArray()) {
            if (item == '(') {
                stack.push('(');
                count++;
            } else if (item == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return count <= n;
    }
}
