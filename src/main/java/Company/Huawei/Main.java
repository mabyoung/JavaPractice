package Company.Huawei;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] aArray = scanner.nextLine().trim().toCharArray();
        char[] bArray = scanner.nextLine().trim().toCharArray();
        long a = 0;
        long b = 0;
        long weigt = 1;
        for (int i = aArray.length - 1; i >= 0; i--) {
            a += (aArray[i] - 'a') * weigt;
            weigt *= 26;
        }
        weigt = 1;
        for (int i = bArray.length - 1; i >= 0; i--) {
            b += (bArray[i] - 'a') * weigt;
            weigt *= 26;
        }
        long sum = a + b;
        if (sum == 0){
            System.out.println("a");
        }
        Stack<Character> stack = new Stack<>();
        while (sum > 0) {
            long tmp = sum % 26;
            stack.push((char) (tmp + 'a'));
            sum /= 26;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
