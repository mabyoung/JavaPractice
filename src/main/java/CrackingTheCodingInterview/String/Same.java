package CrackingTheCodingInterview.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串中的空格。
 *
 * 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
 */
public class Same {
    public boolean checkSam(String stringA, String stringB) {
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();
        for (char c : stringA.toCharArray()) {
            if (mapA.containsKey(c)) {
                mapA.put(c, mapA.get(c) + 1);
            } else {
                mapA.put(c, 1);
            }
        }
        for (char c : stringB.toCharArray()) {
            if (mapB.containsKey(c)) {
                mapB.put(c, mapB.get(c) + 1);
            } else {
                mapB.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : mapA.entrySet()) {
            if (!mapB.containsKey(entry.getKey())) {
                return false;
            }
            if (mapB.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Same same = new Same();
        System.out.println(same.checkSam("This is nowcoder", "is This nowcoder"));
        System.out.println(same.checkSam("Here you are", "Are you here"));
    }
}
