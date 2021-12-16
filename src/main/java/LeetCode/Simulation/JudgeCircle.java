package LeetCode.Simulation;

public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char item : moves.toCharArray()) {
            switch (item) {
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}
