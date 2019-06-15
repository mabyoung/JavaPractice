package LeetCode.Dynamic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start ="hit"
 * end ="cog"
 * dict =["hot","dot","dog","lot","log"]
 * As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length5.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
    public class Node {
        String val;
        int layer;

        Node(String a, int b) {
            val = a;
            layer = b;
        }
    }

    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict.contains(start)) {
            dict.remove(start);
        }
        dict.add(end);
        LinkedList<Node> queue = new LinkedList<>();
        for (Iterator<String> iterator = dict.iterator();iterator.hasNext();){
            String next = iterator.next();
            if (isNear(next, start)){
                if (next.equals(end)){
                    return 2;
                }
                queue.addLast(new Node(next, 1));
                iterator.remove();
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            for (Iterator<String> iterator = dict.iterator();iterator.hasNext();) {
                String next = iterator.next();
                if (isNear(next, node.val)) {
                    if (next.equals(end)) {
                        return node.layer + 2;
                    }
                    iterator.remove();
                    queue.addLast(new Node(next, node.layer+1));
                }
            }
        }
        return 0;
    }

    public boolean isNear(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        String start = "a";
        String end = "c";
        HashSet<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        int length = wordLadder.ladderLength(start, end, dict);
        System.out.println(length);
    }
}
