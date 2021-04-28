package CrackingTheCodingInterview.String;

import java.util.ArrayList;
import java.util.List;

public class Distance {
    public int getDistance(String[] article, int n, String x, String y) {
        List<Integer> wordXIndexList = new ArrayList<>();
        List<Integer> wordYIndexList = new ArrayList<>();
        for (int i = 0; i < article.length; i++) {
            if (article[i].equals(x)) {
                wordXIndexList.add(i);
            }
            if (article[i].equals(y)) {
                wordYIndexList.add(i);
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for (Integer wordXIndex : wordXIndexList) {
            for (Integer wordYIndex : wordYIndexList) {
                if (Math.abs(wordXIndex - wordYIndex) < minDistance) {
                    minDistance = Math.abs(wordXIndex - wordYIndex);
                }
            }
        }
        return minDistance;
    }
}
