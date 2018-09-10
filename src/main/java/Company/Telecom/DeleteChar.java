package Company.Telecom;

import java.util.Scanner;

/**
 * Created by rui on 2018/9/10.
 */
public class DeleteChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().trim().toCharArray();
        int[] frequence = new int[26];
        for (char aChar : chars) {
            frequence[aChar-'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int item : frequence) {
            if (item >0 && item <min){
                min = item;
            }
        }
        for (char aChar : chars) {
            if (frequence[aChar-'a'] != min){
                System.out.print(aChar);
            }
        }
    }

}
