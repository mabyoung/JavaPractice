package Company.Net163;

import java.util.LinkedList;
import java.util.Scanner;

public class Subsequence {
    public static void main(String[] args) {
        LinkedList<Character> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.nextLine().trim().toCharArray();
        char[] t = scanner.nextLine().trim().toCharArray();
        for (char c : t) {
            queue.addLast(c);
        }
        for (char c : s) {
            if (queue.isEmpty()){
                break;
            }
            if (c == queue.getFirst()){
                queue.removeFirst();
            }
        }
        if (queue.isEmpty()){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
