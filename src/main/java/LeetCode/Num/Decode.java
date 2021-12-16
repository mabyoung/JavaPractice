package LeetCode.Num;

import java.util.ArrayList;
import java.util.List;

/**
 * 1734. 解码异或后的排列
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
 */
public class Decode {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] result = new int[n];
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }
        int odd = 0;
        for (int i = 1; i < n - 1; i += 2) {
            odd ^= encoded[i];
        }
        result[0] = total ^ odd;
        for (int i = 1; i < n; i++) {
            result[i] = nextNum(result[i - 1], encoded[i - 1]);
        }
        return result;
    }

    public int nextNum(int perm, int code) {
        List<Integer> permBinary = num2Binary(perm);
        List<Integer> codeBinary = num2Binary(code);
        int size = Math.max(permBinary.size(), codeBinary.size());
        List<Integer> nextBinary = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            int permB = 0;
            if (permBinary.size() > i) {
                permB = permBinary.get(i);
            }
            int codeB = 0;
            if (codeBinary.size() > i) {
                codeB = codeBinary.get(i);
            }
            if (codeB == 0) {
                nextBinary.add(permB);
            } else {
                nextBinary.add(1 - permB);
            }
        }
        return binary2Num(nextBinary);
    }

    public List<Integer> num2Binary(int num) {
        List<Integer> binary = new ArrayList<>();
        while (num != 0) {
            binary.add(num % 2);
            num /= 2;
        }
        return binary;
    }

    public int binary2Num(List<Integer> binary) {
        int result = 0;
        int weight = 1;
        for (Integer item : binary) {
            result += item * weight;
            weight *= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Decode decode = new Decode();
        int[] result = decode.decode(new int[]{12, 6, 11, 10, 5, 3, 4, 6});
        for (int item : result) {
            System.out.println(item);
        }
    }
}
