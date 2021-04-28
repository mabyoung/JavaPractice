package CrackingTheCodingInterview.String;

import java.util.LinkedList;

public class Change {
    public static class StringWithDistance{
        String value;
        int distance;

        StringWithDistance(String value, int distance){
            this.value = value;
            this.distance = distance;
        }
    }

    public int countChanges(String[] dic, int n, String s, String t) {
        boolean[] visited = new boolean[dic.length];
        LinkedList<StringWithDistance> queue = new LinkedList<>();
        queue.add(new StringWithDistance(s, 0));
        while (!queue.isEmpty()) {
            StringWithDistance stringWithDistance = queue.pollFirst();
            for (int i = 0; i < dic.length; i++) {
                if (!visited[i] && isNeighbor(dic[i], stringWithDistance.value)) {
                    if (dic[i].equals(t)) {
                        return stringWithDistance.distance + 1;
                    }
                    queue.add(new StringWithDistance(dic[i], stringWithDistance.distance + 1));
                    visited[i] = true;
                }
            }
        }
        return -1;
    }

    private boolean isNeighbor(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int count = 0;
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] != charsB[i]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        Change change = new Change();
        System.out.println(change.countChanges(new String[]{"abc","adc","bdc","aaa"}, 4, "abc", "bdc"));
    }
}
