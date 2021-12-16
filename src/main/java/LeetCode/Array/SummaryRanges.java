package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int lastNum = nums[0];
        List<List<Integer>> numList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(lastNum);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastNum + 1) {
                numList.add(list);
                list = new ArrayList<>();
            }
            lastNum = nums[i];
            list.add(lastNum);
        }
        numList.add(list);
        List<String> result = new ArrayList<>();
        for (List<Integer> itemList : numList) {
            if (itemList.size() == 1) {
                result.add(String.valueOf(itemList.get(0)));
            } else {
                result.add(itemList.get(0) + "->" + itemList.get(itemList.size() - 1));
            }
        }
        return result;
    }
}
