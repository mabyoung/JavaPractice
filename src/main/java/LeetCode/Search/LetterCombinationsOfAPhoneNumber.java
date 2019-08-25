package LeetCode.Search;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        ArrayList<String> result = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            if (result.size() == 0) {
                result.addAll(map.get(c));
            } else {
                ArrayList<String> tmp = new ArrayList<>();
                for (String s : result) {
                    for (String s1 : map.get(c)) {
                        tmp.add(s + s1);
                    }
                }
                result = new ArrayList<>(tmp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        ArrayList<String> result = letterCombinationsOfAPhoneNumber.letterCombinations("23");
        System.out.println(result);
    }
}
