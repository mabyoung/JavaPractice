package LeetCode.Graph;

import java.util.*;

public class OpenLock {
    class Position {
        String now;
        int step;

        Position(String now, int step) {
            this.now = now;
            this.step = step;
        }
    }

    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")){
            return 0;
        }
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")){
            return -1;
        }
        int result = -1;
        LinkedList<Position> queue = new LinkedList<>();
        Position position = new Position("0000", 0);
        queue.addLast(position);
        Set<String> visited = new HashSet<>();
        visited.add(position.now);
        while (!queue.isEmpty()) {
            Position nowPosition = queue.pollFirst();
            if (nowPosition.now.equals(target)) {
                return nowPosition.step+1;
            }
            for (String nextStatus : get(nowPosition.now)) {
                if (!visited.contains(nextStatus) && !deadSet.contains(nextStatus)) {
                    if (nextStatus.equals(target)) {
                        return nowPosition.step+1;
                    }
                    queue.add(new Position(nextStatus, nowPosition.step+1));
                    visited.add(nextStatus);
                }
            }
        }
        return result;
    }

    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    // 枚举 status 通过一次旋转得到的数字
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }

    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        int result = openLock.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888");
        System.out.println(result);
    }
}
