package Company.nowcoder;

import java.util.Scanner;

public class HardChoice {
    private static void choice(int[] input){
        if (input.length == 0){
            return;
        }
        int index = 0;
        int sum = 0;
        while(index < input.length){
            if (input[index] % 2 == 0){
                sum++;
                input[index]/=2;
            }else{
                index++;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String trim = scanner.nextLine().trim();
        String[] s = trim.split(" ");
        int[] input = new int[n];
        for (int i = 0; i < n; i++){
            input[i] = Integer.parseInt(s[i]);
        }
        choice(input);
    }
}
