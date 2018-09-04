package Company.Ctrip;

import java.util.*;

/**
 * Created by rui on 2018/9/4.
 */
public class LRUCache {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long capacity = Integer.parseInt(scanner.nextLine().trim());
        Map<Long, Long> map = new HashMap<>();
        LinkedList<Long> queue = new LinkedList<>();
        while (scanner.hasNext()){
            String[] split = scanner.nextLine().trim().split(" ");
            long a = Long.parseLong(split[1]);
            if (Objects.equals(split[0], "p")){
                long b = Long.parseLong(split[2]);
                if (!map.containsKey(a)){
                    queue.addLast(a);
                }
                map.put(a,b);
                if (map.size()>capacity){
                    if (!queue.isEmpty()){
                        map.remove(queue.getFirst());
                        queue.removeFirst();
                    }
                }
            } else {
                if (!queue.isEmpty()){
                    queue.removeFirst();
                    queue.addLast(a);
                }
                if (map.containsKey(a) && capacity >= 0){
                    System.out.println(map.get(a));
                }else {
                    System.out.println(-1);
                }
            }
        }
    }
}
