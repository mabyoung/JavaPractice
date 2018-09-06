package Company.Huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by rui on 2018/9/5.
 */
public class CharAContainsCharB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input1 = scanner.nextLine().trim().toCharArray();
        char[] input2 = scanner.nextLine().trim().toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : input1) {
            set.add(c);
        }
        for (char c : input2) {
            if (!set.contains(c)){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
