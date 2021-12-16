package LeetCode;

/**
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 */
public class HammingDistance {
    private static final int HIGH_BIT = 32;

    public int hammingDistance(int x, int y) {
        int result = 0;
        for (int i = 0; i < HIGH_BIT; i++) {
            if (((x>>i)&1) != ((y>>i)&1)){
                result++;
            }
        }
        return result;
    }
}
