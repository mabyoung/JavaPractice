package LeetCode.Simulation;

public class Convert {
    public String convert(String s, int numRows) {
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int index = 0;
        boolean goingDown = true;
        for (char item : s.toCharArray()) {
            if (index < 0 || index >= numRows) {
                index = 0;
            }
            stringBuilders[index].append(item);
            if ((index == 0 && !goingDown) || (index == numRows - 1 && goingDown)) {
                goingDown = !goingDown;
            }
            index += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder item : stringBuilders) {
            if (item != null) {
                result.append(item);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        String result = convert.convert("AB", 1);
        System.out.println(result);
    }
}
