package LeetCode.Simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    class ValueWithTimestamp {
        String value;
        int timestamp;
    }

    private Map<String, List<ValueWithTimestamp>> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        ValueWithTimestamp valueWithTimestamp = new ValueWithTimestamp();
        valueWithTimestamp.value = value;
        valueWithTimestamp.timestamp = timestamp;
        map.computeIfAbsent(key, k -> new ArrayList<>());
        map.get(key).add(valueWithTimestamp);
    }

    public String get(String key, int timestamp) {
        List<ValueWithTimestamp> valueWithTimestampList = map.get(key);
        if (valueWithTimestampList == null || timestamp < valueWithTimestampList.get(0).timestamp){
            return "";
        }
        int left = 0;
        int right = valueWithTimestampList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            ValueWithTimestamp valueWithTimestamp = valueWithTimestampList.get(mid);
            if (valueWithTimestamp.timestamp == timestamp) {
                return valueWithTimestamp.value;
            } else if (valueWithTimestamp.timestamp < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return valueWithTimestampList.get(left - 1).value;
    }


}
