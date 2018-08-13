package DataStructure.Queue;

import java.util.LinkedList;
import java.util.Scanner;

public class SlidingWindowMaxArray {
    private static int[] getMaxWindw(int[] array, int w) {
        if (array.length <= 0 || w <= 0 || array.length < w) {
            return null;
        }
        int result[] = new int[array.length - w + 1];
        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            while (!qmax.isEmpty() && array[qmax.peekLast()] <= array[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                result[index++] = array[qmax.peekFirst()];
            }
        }
        return result;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(" ");
        int w = Integer.parseInt(scanner.nextLine().trim());
        int n = split.length;
        int[]array = new int[n];
        for (int i = 0;i<n;i++){
            array[i] = Integer.parseInt(split[i]);
        }
        int[] maxWindw = getMaxWindw(array, w);
        printArray(maxWindw);
    }
}
