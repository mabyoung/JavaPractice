package Company.Telecom;

import java.util.Scanner;

/**
 * Created by rui on 2018/9/10.
 */
public class OverlaySubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String trim = scanner.nextLine().trim();
        int indexOf = trim.indexOf(" ");
        char[] chars1 = trim.substring(0, indexOf).trim().toCharArray();
        char[] chars2 = trim.substring(indexOf, trim.length()).trim().toCharArray();
        System.out.println(Math.max(solve(chars1,chars2),solve(chars2,chars1)));
    }
    public static int solve (char[] chars1, char[] chars2){
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i+j]!=chars2[j]){
                    break;
                }
                if (i+j == chars1.length-1){
                    return j+1;
                }
            }
        }
        return 0;
    }
}
