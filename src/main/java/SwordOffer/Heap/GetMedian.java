package SwordOffer.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 思路：为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
 * 1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
 * 2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
 */
public class GetMedian {
    public static int count;
    public static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public static void insert(Integer num) {
        if ((++count & 1) == 0) {
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        } else {
            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        }
    }

    public static Double getMedian() {
        if ((count & 1) == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        insert(5);
        insert(2);
        System.out.println(getMedian());
    }
}
