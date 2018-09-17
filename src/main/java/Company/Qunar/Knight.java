package Company.Qunar;

import java.util.*;

/**
 * 马走棋盘
 */
class Locate {
    int locateI;
    int locateJ;
    int step;

    public Locate(int locateI, int locateJ, int step) {
        this.locateI = locateI;
        this.locateJ = locateJ;
        this.step = step;
    }
}

public class Knight {
    public static boolean isLegal(int i, int j){
        if (i>=1 && j>=1 && i<=8 && j<=8){
            return true;
        }
        return false;
    }
    public static int bfs(int startI, int startJ, int endI, int endJ) {
        int move[][] = {{-2,-1},{-2,+1},{-1,-2},{-1,+2},{+1,-2},{+1,+2},{+2,-1},{+2,+1}};
        LinkedList<Locate> queue = new LinkedList<>();
        Locate locate = new Locate(startI, startJ, 0);
        int visited[][] = new int[9][9];
        queue.addLast(locate);
        while (!queue.isEmpty()) {
            Locate first = queue.getFirst();
            if (first.locateI == endI && first.locateJ == endJ){
                return first.step;
            }
            queue.removeFirst();
            visited[first.locateI][first.locateJ] = 1;
            for (int i =0;i<move.length;i++){
                if (isLegal(first.locateI+move[i][0],first.locateJ+move[i][1]) && visited[first.locateI+move[i][0]][first.locateJ+move[i][1]]==0){
                    Locate tmp = new Locate(first.locateI+move[i][0], first.locateJ+move[i][1], first.step + 1);
                    queue.addLast(tmp);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startI = scanner.nextInt();
        int startJ = scanner.nextInt();
        int endI = scanner.nextInt();
        int endJ = scanner.nextInt();
        System.out.println(bfs(startI, startJ, endI, endJ));
    }
}
