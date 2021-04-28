package OldExams2016.Simulation;

import java.util.LinkedList;
import java.util.Scanner;

public class DeleteNumber {
    public static int getTheLastNumber(int n) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.addLast(i);
        }
        while (linkedList.size() > 1) {
            for (int i = 0; i < 2; i++) {
                Integer first = linkedList.removeFirst();
                linkedList.addLast(first);
            }
            linkedList.removeFirst();
        }
        return linkedList.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(getTheLastNumber(n));
        }
    }
}
