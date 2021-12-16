package LeetCode.Simulation;

public class OrchestraLayout {
    public int orchestraLayout(int num, int xPos, int yPos) {
        int x = 0;
        int y = 0;
        int left = 0;
        int right = num - 1;
        long index = 0;
        while (x != xPos || y != yPos) {
            if (x != xPos) {
                y = right;
                index += (right-left);
            } else {
                index += (yPos - left + 1);
                break;
            }
            if (y != yPos) {
                x = right;
                index += (right-left);
            } else {
                index += (xPos - left + 1);
                break;
            }
            if (x != xPos) {
                y = left;
                index += (right-left);
            } else {
                index += (right - yPos + 1);
                break;
            }
            if (y != yPos) {
                x = left + 1;
                index += (right-left);
            } else {
                index += (right - xPos + 1);
                break;
            }
            left++;
            right--;
        }
        return (int) ((index - 1) % 9 + 1);
    }

    public static void main(String[] args) {
        OrchestraLayout orchestraLayout = new OrchestraLayout();
        System.out.println(orchestraLayout.orchestraLayout(4, 0, 3));
    }
}
