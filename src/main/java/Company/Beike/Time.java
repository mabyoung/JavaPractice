package Company.Beike;

import java.util.Scanner;

public class Time {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while(n-->0){
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            char[] chars = split[0].toCharArray();
            int hour =Integer.parseInt(split[1]);
            if (chars[3] == '+'){
                hour = hour - 8+(chars[4]-'0');
            }else{
                hour = hour-8-(chars[4]-'0');
            }
            if (hour <0){
                hour +=24;
            }
            if (hour<10){
                System.out.print("0"+hour+":");
            }else{
                System.out.print(hour+":");
            }
            if (split[2].length()==1){
                System.out.print("0"+split[2]);
            }else{
                System.out.print(split[2]);
            }
        }
    }
}
