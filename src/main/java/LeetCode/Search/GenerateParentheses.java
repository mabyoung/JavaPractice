package LeetCode.Search;

import java.util.ArrayList;

/**
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        dfs(result, "", 0, 0, n);
        return result;
    }

    public void dfs(ArrayList<String> result, String current, int leftNum, int rightNum, int n) {
        if (leftNum == n && rightNum == n) {
            result.add(current);
        } else if (leftNum < rightNum || leftNum > n) {
            return;
        }
        dfs(result, current + "(", leftNum + 1, rightNum, n);
        dfs(result, current + ")", leftNum, rightNum + 1, n);
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        ArrayList<String> result = generateParentheses.generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
