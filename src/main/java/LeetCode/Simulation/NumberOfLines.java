package LeetCode.Simulation;

public class NumberOfLines {
    public int[] numberOfLines(int[] widths, String s) {
        int line = 1;
        int cell = 0;
        for (char c : s.toCharArray()) {
            int targetCell = widths[c - 'a'] + cell;
            if (targetCell > 100) {
                line++;
                cell = widths[c - 'a'];
            } else {
                cell = targetCell;
            }
        }
        return new int[]{line, cell};
    }
}
