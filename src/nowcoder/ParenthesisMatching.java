package nowcoder;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisMatching {
    public static int sum = 0;
    private static void check(char[] input){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length; i++){
            if (input[i] == '('){
                stack.push('(');
            } else if (input[i] == ')'){
                if (stack.isEmpty()){
                    return;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()){
            sum++;
        }
    }

    private static Stack<Character> preLeft(char[] input){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length; i++){
            if (input[i] == '('){
                stack.push('(');
            } else if (input[i] == ')'){
                if (stack.isEmpty()){
                    return null;
                }
                stack.pop();
            }
        }
        return stack;
    }

    private static void checkRight(Stack<Character> stack, char[] input){
        for (int i = 0; i < input.length; i++){
            if (input[i] == '('){
                stack.push('(');
            } else if (input[i] == ')'){
                if (stack.isEmpty()){
                    return;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()){
            sum++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        char[][] input = new char[n][];
        for (int i = 0; i < n; i++){
            input[i] = scanner.nextLine().trim().toCharArray();
            check(input[i]);
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (input[i][0] == ')'){
                    break;
                }
                if (i != j){
                    Stack<Character> stack = preLeft(input[i]);
                    if (stack == null){
                        break;
                    }
                    checkRight(stack, input[j]);
                }
            }
        }
        System.out.println(sum);
    }
}
