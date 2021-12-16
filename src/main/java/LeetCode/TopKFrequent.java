package LeetCode;

import java.util.*;

public class TopKFrequent {
    public class WordWithFrequent{
        String word;
        int frequent;
        WordWithFrequent(String word, int frequent){
            this.word = word;
            this.frequent = frequent;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        List<WordWithFrequent> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new WordWithFrequent(entry.getKey(), entry.getValue()));
        }
        list.sort((o1, o2) -> {
            if (o1.frequent == o2.frequent){
                return o1.word.compareTo(o2.word);
            }else {
                return o2.frequent - o1.frequent;
            }
        });
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).word);
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        List<String> result = topKFrequent.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
