package LeetCode.Simulation;

public class FindCheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] edges = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    edges[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int[] flight : flights) {
            edges[flight[0]][flight[1]] = flight[2];
        }
        boolean[] visited = new boolean[n];
        visited[src] = true;
        while (--k >= 0) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                if (edges[src][i] < minDistance) {
                    minDistance = edges[src][i];
                    minIndex = i;
                }
            }
            if (minIndex == -1) {
                break;
            }
            visited[minIndex] = true;
            for (int j = 0; j < n; j++) {
                if (edges[minIndex][j] != Integer.MAX_VALUE && edges[minIndex][j] + minDistance < edges[src][j]){
                    edges[src][j] = edges[minIndex][j] + minDistance;
                }
            }
        }
        return edges[src][dst] == Integer.MAX_VALUE ? -1 : edges[src][dst];
    }

    public static void main(String[] args) {
        FindCheapestPrice findCheapestPrice = new FindCheapestPrice();
        int result = findCheapestPrice.findCheapestPrice(4, new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}}, 0, 3, 1);
        System.out.println(result);
    }
}
