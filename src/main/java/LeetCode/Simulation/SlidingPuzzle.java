package LeetCode.Simulation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        StringBuilder begin = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                begin.append(board[i][j]);
            }
        }
        String end = "123450";
        if (begin.toString().equals(end)) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.add(begin.toString());
        Set<String> visited = new HashSet<>();
        visited.add(begin.toString());
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String now = queue.pollFirst();
                for (int p = 1; p <= 4; p++) {
                    String next = getNext(now, p);
                    if (next.equals(end)){
                        return step;
                    }
                    if (!visited.contains(next)){
                        queue.addLast(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }

    public String getNext(String now, int movePosition) {
        int i = now.indexOf("0");
        char[] chars = now.toCharArray();
        switch (movePosition) {
            case 1:
                if (i == 1 || i == 2 || i == 4 | i == 5) {
                    exchange(chars, i, i - 1);
                }
                break;
            case 2:
                if (i == 0 || i == 1 || i == 3 || i == 4) {
                    exchange(chars, i, i + 1);
                }
                break;
            case 3:
                if (i >= 3 && i <= 5) {
                    exchange(chars, i, i - 3);
                }
                break;
            case 4:
                if (i >= 0 && i <= 2) {
                    exchange(chars, i, i + 3);
                }
                break;
        }
        return new String(chars);
    }

    public void exchange(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        System.out.println(slidingPuzzle.slidingPuzzle(new int[][]{{3,2,4},{1,5,0}}));

    }
}
