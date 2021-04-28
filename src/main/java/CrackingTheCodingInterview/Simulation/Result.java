package CrackingTheCodingInterview.Simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * 我们现在有四个槽，每个槽放一个球，颜色可能是红色(R)、黄色(Y)、绿色(G)或蓝色(B)。
 * 例如，可能的情况为RGGB(槽1为红色，槽2、3为绿色，槽4为蓝色)，作为玩家，你需要试图猜出颜色的组合。
 * 比如，你可能猜YRGB。要是你猜对了某个槽的颜色，则算一次“猜中”。要是只是猜对了颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * 给定两个string A和guess。分别表示颜色组合，和一个猜测。请返回一个int数组，第一个元素为猜中的次数，第二个元素为伪猜中的次数。
 */
public class Result {
    public int[] calcResult(String A, String guess) {
        int hitNum = 0;
        int halfHitNum = 0;
        Map<Character, Integer> realMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == guess.charAt(i)) {
                hitNum++;
            } else {
                if (realMap.containsKey(A.charAt(i))) {
                    realMap.put(A.charAt(i), realMap.get(A.charAt(i)) + 1);
                } else {
                    realMap.put(A.charAt(i), 1);
                }
                if (guessMap.containsKey(guess.charAt(i))) {
                    guessMap.put(guess.charAt(i), guessMap.get(guess.charAt(i)) + 1);
                } else {
                    guessMap.put(guess.charAt(i), 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> realMapItem : realMap.entrySet()) {
            if (guessMap.containsKey(realMapItem.getKey())) {
                halfHitNum += Math.min(realMapItem.getValue(), guessMap.get(realMapItem.getKey()));
            }
        }
        return new int[]{hitNum, halfHitNum};
    }
}
