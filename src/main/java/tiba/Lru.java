package tiba;

import java.util.*;

public class Lru {
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int[] operator : operators) {
            if (operator[0] == 1) {
                if (map.size() == k){
                    Iterator<Integer> iterator = map.keySet().iterator();
                    map.remove(iterator.next());
                }
                map.put(operator[1], operator[2]);
            } else {
                Integer value = map.get(operator[1]);
                if (value == null){
                    result.add(-1);
                }else{
                    result.add(value);
                    map.remove(operator[1]);
                    map.put(operator[1], value);
                }
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }

    public static void main(String[] args) {
        Lru lru = new Lru();
        int[] result = lru.LRU(new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}}, 3);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
