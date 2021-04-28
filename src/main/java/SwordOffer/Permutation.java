package SwordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {
    public static void swap(char[] charArray, int i, int j){
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
    }

    public static void solve(int index, char[] charArray, HashSet<String> result) {
        if (index == charArray.length) {
            StringBuffer stringBuffer = new StringBuffer("");
            for (char c : charArray) {
                stringBuffer = stringBuffer.append(c);
            }
            result.add(stringBuffer.toString());
        } else {
            for (int i = index;i<charArray.length;i++){
                swap(charArray, i, index);
                solve(index+1, charArray, result);
                swap(charArray, i, index);
            }
        }
    }

    public static ArrayList<String> permutation(String str) {
        HashSet<String> result = new HashSet<>();
        if(str != null && !str.equals("")){
            solve(0, str.toCharArray(), result);
        }
        ArrayList<String> list = new ArrayList<>();
        for (String s : result) {
            list.add(s);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        ArrayList<String> permutation = permutation(input);
        for (String s : permutation) {
            System.out.print(s + " ");
        }
    }
}
