package LeetCode.Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxTwoEvents {
    public class Event {
        int startTime;
        int endTime;
        int value;
    }

    public int maxTwoEvents(int[][] events) {
        List<Event> eventList = new ArrayList<>();
        int maxEndTime = Integer.MIN_VALUE;
        for (int[] item : events) {
            Event event = new Event();
            event.startTime = item[0] - 1;
            event.endTime = item[1];
            event.value = item[2];
            eventList.add(event);
            maxEndTime = Math.max(maxEndTime, event.endTime);
        }
        eventList.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                if (o1.endTime == o2.endTime) {
                    return o1.value - o2.value;
                }
                return o1.endTime - o2.endTime;
            }
        });
        int result = 0;
        int right = eventList.size() - 1;
        for (int i = 0; i < eventList.size(); i++) {
            Event eventA = eventList.get(i);
            for (int j = 0; j < eventList.size(); j++) {
                Event eventB = eventList.get(j);
                if (eventB.startTime >= eventA.endTime) {
                    result = Math.max(result, eventA.value + eventB.value);
                } else {
                    result = Math.max(result, eventA.value);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxTwoEvents maxTwoEvents = new MaxTwoEvents();
        int result = maxTwoEvents.maxTwoEvents(new int[][]{{10, 83, 53}, {63, 87, 45}, {97, 100, 32}, {51, 61, 16}});
        System.out.println(result);
    }
}
