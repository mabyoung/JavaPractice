package LeetCode.Array;

/**
 * 集合[1,2,3,…,n]一共有n!种不同的排列
 * 按字典序列出所有的排列并且给这些排列标上序号
 * 我们就会得到以下的序列（以n=3为例）
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 现在给出n和k，请返回第k个排列
 * 注意：n在1到9之间
 */
public class PermutationSequence {
    public String getPermutaion(int n, int k) {
        int count = 0;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
        }
        while (++count < k) {
            num = getNext(num);
        }
        StringBuilder result = new StringBuilder();
        for (int item : num) {
            result.append(item);
        }
        return result.toString();
    }

    private int[] getNext(int[] num) {
        int i = num.length - 1;
        while (i > 0 && num[i] <= num[i - 1]) {
            i--;
        }
        if (i == 0) {
            return reverse(num, 0, num.length - 1);
        }
        int j = i;
        while (j <= num.length - 2 && num[j + 1] > num[i-1]) {
            j++;
        }
        int tmp = num[i - 1];
        num[i - 1] = num[j];
        num[j] = tmp;
        return reverse(num, i, num.length - 1);
    }

    private int[] reverse(int[] num, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
        return num;
    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        String result = permutationSequence.getPermutaion(3, 5);
        System.out.println(result);
    }
}
