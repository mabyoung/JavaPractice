package OldExams2016;

import java.util.HashMap;

public class FirstRepeat {
    public char findFirstRepeat(String A, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(A.charAt(i))) {
                return A.charAt(i);
            } else {
                map.put(A.charAt(i), 1);
            }
        }
        return 'y';
    }
}
