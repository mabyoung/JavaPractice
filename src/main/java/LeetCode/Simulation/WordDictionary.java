package LeetCode.Simulation;

public class WordDictionary {
    class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode cursor = root;
        for (char item : chars) {
            if (cursor.tns[item - 'a'] == null) {
                cursor.tns[item - 'a'] = new TrieNode();
            }
            cursor = cursor.tns[item - 'a'];
        }
        cursor.end = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int nextIndex, TrieNode cursor) {
        if (cursor == null) {
            return false;
        }
        if (nextIndex >= word.length()) {
            return cursor.end;
        }
        if (word.charAt(nextIndex) == '.') {
            for (TrieNode node : cursor.tns) {
                if (search(word, nextIndex + 1, node)) {
                    return true;
                }
            }
            return false;
        } else {
            return search(word, nextIndex + 1, (cursor.tns[word.charAt(nextIndex) - 'a']));
        }
    }
}
