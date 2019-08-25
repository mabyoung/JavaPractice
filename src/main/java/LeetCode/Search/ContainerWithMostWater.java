package LeetCode.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定n个非负整数a1，a2，…，an，其中每个数字表示坐标(i, ai)处的一个点。以（i，ai）和（i，0）（i=1,2,3...n）为端点画出n条直线。你可以从中选择两条线与x轴一起构成一个容器，最大的容器能装多少水？
 * 注意：你不能倾斜容器
 * 例如：
 * 输入 [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 链接：https://www.nowcoder.com/questionTerminal/c97c1400a425438fb130f54fdcef0c57
 * 来源：牛客网
 * <p>
 * 这题最关键的是两点，一是两边往中间找，二是每次放弃最短的版。
 * 这么做的原因在于：从起点和终点开始找，宽度最大，这时每移动一次其中一个点，必然宽度变小。
 * 如此一来，想求最大，只有高度增长才有可能做到，去掉限制----短板，即放弃高度较小的点。
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            if (height[i] < height[j]) {
                result = Math.max(result, height[i] * (j - i));
                i++;
            } else {
                result = Math.max(result, height[j] * (j - i));
                j--;
            }
        }
        return result;
    }

    public int maxArea1(int[] height) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            if (list.size() == 0) {
                list.add(i);
            } else {
                for (Integer index : list) {
                    result = Math.max(result, Math.min(height[i], height[index]) * (i - index));
                }
                if (height[i] > height[list.get(list.size() - 1)]) {
                    list.add(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int result = containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(result);
    }
}
