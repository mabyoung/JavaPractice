package LeetCode.Array;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDetonation {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        boolean[][] edges = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = getDistance(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1]);
                if (distance <= bombs[i][2]) {
                    edges[i][j] = true;
                }
                if (distance <= bombs[j][2]) {
                    edges[j][i] = true;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, traver(i, edges));
        }
        return max;
    }

    public int traver(int start, boolean[][] edges) {
        int n = edges.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (int i = 0; i < n; i++) {
                if (edges[now][i] && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((long)(x2 - x1) * (x2 - x1) + (long)(y2 - y1) * (y2 - y1));
    }

    public static void main(String[] args) {
        MaximumDetonation maximumDetonation = new MaximumDetonation();
        int result = maximumDetonation.maximumDetonation(new int[][]{{85024,58997,3532},{65196,42043,9739},{85872,75029,3117},{73014,91183,7092},{29098,40864,7624},{11469,13607,4315},{98722,69681,9656},{75140,42250,421},{92580,44040,4779},{58474,78273,1047},{27683,4203,6186},{10714,24238,6243},{60138,81791,3496},{16227,92418,5622},{60496,64917,2463},{59241,62074,885},{11961,163,5815},{37757,43214,3402},{21094,98519,1678},{49368,22385,1431},{6343,53798,159},{80129,9282,5139},{69565,32036,6827},{59372,64978,6575},{44948,71199,7095},{46390,91701,1667},{37144,98691,8128},{13558,81505,4653},{41234,48161,9304},{14852,3206,5369}});
        System.out.println(result);
    }
}
