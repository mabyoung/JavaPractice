package LeetCode.Complexity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumberII {
    public int singleNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : A) {
            if (!map.containsKey(item)){
                map.put(item, 1);
            }else{
                map.put(item,map.get(item)+1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1};
        SingleNumberII singleNumberII = new SingleNumberII();
        System.out.println(singleNumberII.singleNumber(A));
    }
}
