package LeetCode.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
        }
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int index = 0; index <= s.length() - 10; index++) {
            String subString = s.substring(index, index + 10);
            if (set.contains(subString)) {
                result.add(subString);
            } else {
                set.add(subString);
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        FindRepeatedDnaSequences findRepeatedDnaSequences = new FindRepeatedDnaSequences();
        System.out.println(findRepeatedDnaSequences.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
