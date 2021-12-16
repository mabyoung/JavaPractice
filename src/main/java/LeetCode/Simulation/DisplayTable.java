package LeetCode.Simulation;

import java.util.*;

public class DisplayTable {
    public List<List<String>> displayTable1(List<List<String>> orders) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Set<String> tableNumSet = new HashSet<>();
        Set<String> foodItemSet = new HashSet<>();
        for (List<String> order : orders) {
            String tableNum = order.get(1);
            String foodItem = order.get(2);
            tableNumSet.add(tableNum);
            foodItemSet.add(foodItem);
            String key = tableNum + "_" + foodItem;
            map.merge(key, 1, Integer::sum);
        }
        List<String> tableNumList = new ArrayList<>(tableNumSet);
        tableNumList.sort(Comparator.comparingInt(Integer::parseInt));
        List<String> foodItemList = new ArrayList<>(foodItemSet);
        foodItemList.sort(Comparator.naturalOrder());
        List<String> titleList = new LinkedList<>(foodItemList);
        titleList.add(0, "Table");
        result.add(titleList);
        for (String tableNum : tableNumList) {
            List<String> list = new ArrayList<>();
            list.add(tableNum);
            for (String foodItem : foodItemList) {
                String key = tableNum + "_" + foodItem;
                Integer value = map.get(key);
                if (value == null) {
                    value = 0;
                }
                list.add(String.valueOf(value));
            }
            result.add(list);
        }
        return result;
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        // 从订单中获取餐品名称和桌号，统计每桌点餐数量
        Set<String> foodItemSet = new HashSet<>();
        Map<Integer, Map<String, Integer>> foodsCnt = new HashMap<>();
        for (List<String> order : orders) {
            int tableNum = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            foodItemSet.add(foodItem);
            Map<String, Integer> map = foodsCnt.getOrDefault(tableNum, new HashMap<>());
            map.merge(foodItem, 1, Integer::sum);
            foodsCnt.put(tableNum, map);
        }

        // 提取餐品名称，并按字母顺序排列
        List<String> foodItemList = new ArrayList<>(foodItemSet);
        Collections.sort(foodItemList);

        // 提取桌号，并按餐桌桌号升序排列
        List<Integer> tableNumList = new ArrayList<>(foodsCnt.keySet());
        Collections.sort(tableNumList);

        // 填写点菜展示表
        List<List<String>> table = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodItemList);
        table.add(header);
        for (Integer tableNum : tableNumList) {
            Map<String, Integer> cnt = foodsCnt.get(tableNum);
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(tableNum));
            for (String foodItem : foodItemList) {
                row.add(Integer.toString(cnt.getOrDefault(foodItem, 0)));
            }
            table.add(row);
        }
        return table;
    }
}
