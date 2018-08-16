package DataStructure.Queue;

import java.util.LinkedList;
import java.util.Scanner;

public class AllLessNumSubArray {
    private static int getNum(int[] array, int num) {
        if (array == null || array.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i = 0, j = 0, result = 0;
        while (i < array.length) {
            while (j < array.length) {
                while (!qmin.isEmpty() && array[qmin.peekLast()] >= array[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && array[qmax.peekLast()] <= array[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (array[qmax.peekFirst()] - array[qmin.peekFirst()] > num) {
                    break;
                }
                j++;
            }
            if (i == qmin.peekFirst()) {
                qmin.pollFirst();
            }
            if (i == qmax.peekFirst()) {
                qmax.pollFirst();
            }
            result += j - i;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(" ");
        int num = Integer.parseInt(scanner.nextLine().trim());
        int n = split.length;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        int result = getNum(array, num);
        System.out.println(result);
    }
}
