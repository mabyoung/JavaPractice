package LeetCode.Dynamic;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 *
 * 思路：递归判断从第i个位置开始到结尾的字符子串是否在字典中
 */
public class WordBreakII {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<>();
        wordBreakHelper(s, s.length(), dict, result);
        return result;
    }
    public void wordBreakHelper(String s, int endIndex, Set<String> dict, ArrayList<String > result){
        if (endIndex == 0){
            result.add(s.trim());
        }
        for(int i = endIndex-1;i>=0;i--){
            if (dict.contains(s.substring(i, endIndex))){
                wordBreakHelper(s.substring(0,i)+" "+s.substring(i), i, dict, result);
            }
        }
    }

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        ArrayList<String> result = wordBreakII.wordBreak("catsanddog", dict);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
