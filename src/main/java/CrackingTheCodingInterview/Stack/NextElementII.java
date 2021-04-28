package CrackingTheCodingInterview.Stack;

import java.util.ArrayList;
import java.util.List;

public class NextElementII {
    public int[] findNext(int[] A, int n) {
        int[] result = new int[A.length];
        List<Integer> list = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            result[i] = insertIntoListInOrder(list, A[i]);
        }
        return result;
    }

    private int insertIntoListInOrder(List<Integer> list, int targetValue) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > targetValue) {
                list.add(i, targetValue);
                return list.get(i + 1);
            }
        }
        list.add(targetValue);
        return -1;
    }

    public static void main(String[] args) {
        NextElementII nextElementII = new NextElementII();
        int[] result = nextElementII.findNext(new int[]{11, 13, 10, 5, 12, 21, 3}, 7);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
