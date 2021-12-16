package LeetCode.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int[] newBoard = buildNewBoard(board);
        int n = board.length;
        int target = n * n;
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(1);
        visited.add(1);
        int step = 0;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            step++;
            for (int i = 0; i < queueSize; i++) {
                Integer now = queue.pollFirst();
                for (int j = 1; j <= 6; j++) {
                    Integer next = now + j;
                    if (next > target){
                        break;
                    }
                    if (newBoard[next] != -1){
                        next = newBoard[next];
                    }
                    if (next == target){
                        return step;
                    }
                    if (!visited.contains(next)){
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }
        return -1;
    }

    public int[] buildNewBoard(int[][] board) {
        int n = board.length;
        int i = n - 1;
        int j = 0;
        int[] newBoard = new int[n * n+1];
        for (int index = 1; index < newBoard.length; index++) {
            newBoard[index] = board[i][j];
            if ((n - i) % 2 == 0) {
                if (j == 0) {
                    i--;
                } else {
                    j--;
                }
            } else {
                if (j == n - 1) {
                    i--;
                } else {
                    j++;
                }
            }
        }
        return newBoard;
    }

    public static void main(String[] args) {
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        int[][] board = new int[][]{
                {-1,1,2,-1},{2,13,15,-1},{-1,10,-1,-1},{-1,6,2,8}
        };
        int result = snakesAndLadders.snakesAndLadders(board);
        System.out.println(result);
    }
}
