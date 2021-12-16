package LeetCode.String;

import java.util.*;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, List<Character>> map = new HashMap<Character, List<Character>>() {
            {
                put('2', Arrays.asList('a', 'b', 'c'));
                put('3', Arrays.asList('d', 'e', 'f'));
                put('4', Arrays.asList('g', 'h', 'i'));
                put('5', Arrays.asList('j', 'k', 'l'));
                put('6', Arrays.asList('m', 'n', 'o'));
                put('7', Arrays.asList('p', 'q', 'r', 's'));
                put('8', Arrays.asList('t', 'u', 'v'));
                put('9', Arrays.asList('w', 'x', 'y', 'z'));
            }
        };
        for (char digit : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (Character character : map.get(digit)) {
                if (result.isEmpty()) {
                    tmp.add((String.valueOf(character)));
                } else {
                    for (String item : result) {
                        tmp.add(item + character);
                    }
                }
            }
            result = tmp;
        }
        return result;
    }
}
