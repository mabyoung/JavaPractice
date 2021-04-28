package CrackingTheCodingInterview.Basis;

/**
 * 请设计一个高效的方法，找出任意指定单词在一篇文章中的出现频数。
 * 给定一个string数组article和数组大小n及一个待统计单词word，请返回该单词在文章中的出现频数。保证文章的词数小于等于1000。
 */
public class Frequency {
    public class TrieNode {
        TrieNode[] childes;
        int count;

        TrieNode() {
            childes = new TrieNode[26];
            count = 0;
        }

        public void insert(String word) {
            insert(word, 0);
        }

        private void insert(String word, int layer) {
            if (word.length() == layer) {
                count++;
                return;
            }
            int index = word.charAt(layer) - 'a';
            if (childes[index] == null) {
                childes[index] = new TrieNode();
            }
            childes[index].insert(word, layer + 1);
        }

        public TrieNode search(String word) {
            return search(word, 0);
        }

        private TrieNode search(String word, int layer) {
            if (word.length() == layer) {
                return this;
            }
            int index = word.charAt(layer) - 'a';
            if (childes[index] == null) {
                return null;
            }
            return childes[index].search(word, layer + 1);
        }
    }


    public int getFrequency(String[] article, int n, String word) {
        TrieNode root = new TrieNode();
        for (String item : article) {
            root.insert(item);
        }
        TrieNode search = root.search(word);
        return search == null ? 0 : search.count;
    }

    public static void main(String[] args) {
        Frequency frequency = new Frequency();
        int result = frequency.getFrequency(new String[]{"abcd"}, 1, "dcba");
        System.out.println(result);
    }
}
