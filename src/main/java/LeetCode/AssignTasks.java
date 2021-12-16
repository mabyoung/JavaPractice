package LeetCode;

import java.util.*;

public class AssignTasks {
    class ServerState {
        int weight;
        int index;
        int nextWorkTime;

        ServerState(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<ServerState> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a.nextWorkTime));
        PriorityQueue<ServerState> idle = new PriorityQueue<>((a, b) -> {
            if (a.weight != b.weight) {
                return a.weight - b.weight;
            }
            return a.index - b.index;
        });
        for (int i = 0; i < servers.length; i++) {
            idle.add(new ServerState(servers[i], i));
        }
        int ts = 0;
        int[] result = new int[tasks.length];
        int index = 0;
        for (int i = 0; i < tasks.length; i++) {
            ts = Math.max(ts, i);
            while (!busy.isEmpty() && busy.peek().nextWorkTime <= ts) {
                idle.add(busy.poll());
            }
            if (idle.isEmpty()) {
                ts = busy.peek().nextWorkTime;
                i--;
                continue;
            }
            ServerState poll = idle.poll();
            poll.nextWorkTime = ts + tasks[i];
            busy.add(poll);
            result[index++] = poll.index;
        }
        return result;
    }

    public static void main(String[] args) {
        AssignTasks assignTasks = new AssignTasks();
        int[] result = assignTasks.assignTasks(new int[]{31, 96, 73, 90, 15, 11, 1, 90, 72, 9, 30, 88}, new int[]{87, 10, 3, 5, 76, 74, 38, 64, 16, 64, 93, 95, 60, 79, 54, 26, 30, 44, 64, 71});
        for (int item : result) {
            System.out.println(item);
        }
    }
}
