package LeetCode;

public class MemLeak {
    public int[] memLeak(int memory1, int memory2) {
        int i = 1;
        while (true) {
            if (memory1 >= memory2) {
                if (memory1 >= i) {
                    memory1 -= i;
                } else {
                    break;
                }
            } else {
                if (memory2 >= i) {
                    memory2 -= i;
                } else {
                    break;
                }
            }
            i++;
        }
        return new int[]{i, memory1, memory2};
    }

    public static void main(String[] args) {
        MemLeak memLeak = new MemLeak();
        int[] result = memLeak.memLeak(8, 11);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
