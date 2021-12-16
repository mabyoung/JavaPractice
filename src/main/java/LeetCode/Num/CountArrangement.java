package LeetCode.Num;


public class CountArrangement {
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n];
        return dfs(0, visited);
    }

    public int dfs(int index, boolean[] visited) {
        if (index >= visited.length) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && ((index + 1) % (i + 1) == 0 || (i + 1) % (index + 1) == 0)) {
                visited[i] = true;
                result += dfs(index + 1, visited);
                visited[i] = false;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        CountArrangement countArrangement = new CountArrangement();
        int result = countArrangement.countArrangement(4);
        System.out.println(result);
    }

}
