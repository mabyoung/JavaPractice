package Coderwars.Kyu6;

public class TwoToOne {
    public static String longest (String s1, String s2) {
        int[] letters = new int[26];
        StringBuilder result = new StringBuilder();
        for (char c : s1.toCharArray()) {
            letters[c-'a'] = 1;
        }
        for (char c : s2.toCharArray()) {
            letters[c-'a'] = 1;
        }
        for (int i =0 ;i<letters.length;i++) {
            if (letters[i] == 1){
                char item = (char)('a'+i);
                result.append(item);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));
    }
}
