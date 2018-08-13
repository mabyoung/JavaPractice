package Net163;

import java.util.Scanner;

public class InterstellarCross {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long h = Long.parseLong(scanner.nextLine().trim());
        long x = (int)Math.floor(Math.sqrt(h));
        while(true){
            if (x+x*x > h){
                x--;
            }else{
                break;
            }
        }
        System.out.println(x);
    }
}
