package SwordOffer.String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstAppearingOnce {
    private static Map<Character, Integer> map = new HashMap<>();
    private static LinkedList<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public static void insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
            queue.addLast(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public static char firstAppearingOnce() {
        while (!queue.isEmpty() && map.get(queue.peekFirst()) > 1) {
            queue.removeFirst();
        }
        if (queue.isEmpty()) {
            return '#';
        }
        return queue.peekFirst();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().trim().toCharArray();
        for (char aChar : chars) {
            insert(aChar);
            System.out.println(firstAppearingOnce());
        }

    }
}
