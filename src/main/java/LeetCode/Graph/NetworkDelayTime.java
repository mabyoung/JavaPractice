package LeetCode.Graph;

import java.util.Arrays;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] distance = new int[n + 1][n + 1];
        for (int[] ints : distance) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for (int[] time : times) {
            distance[time[0]][time[1]] = time[2];
        }
        for (int i = 1; i <= n; i++) {
            distance[i][i] = 0;
        }
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 1; j <= n; j++) {
                if (j != k && !visited[j] && distance[k][j] < min) {
                    min = distance[k][j];
                    index = j;
                }
            }
            if (index == -1) {
                return -1;
            }
            visited[index] = true;
            for (int j = 1; j <= n; j++) {
                if (distance[index][j] != Integer.MAX_VALUE) {
                    distance[k][j] = Math.min(distance[k][j], distance[k][index] + distance[index][j]);
                }
            }
        }
        int max = -1;
        for (int i = 1; i <= n; i++) {
            if (distance[k][i] > max && distance[k][i] != Integer.MAX_VALUE) {
                max = distance[k][i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int result = networkDelayTime.networkDelayTime(new int[][]{{1,2,1},{2,3,7},{1,3,4},{2,1,2}}, 4, 1);
        System.out.println(result);
    }
}
