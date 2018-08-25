package Company.Tuniu;

import java.util.Scanner;

public class PrintAllSubsequence {
    public static void printAllSubsequence(char[] input, int i, String result){
        if (i == input.length){
            System.out.println(result);
        } else {
            //不要第i+1个字符
            printAllSubsequence(input, i+1, result);
            //要第i+1个字符
            printAllSubsequence(input, i+1, result+input[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        printAllSubsequence(input.toCharArray(), 0, "");
    }
}
