package OldExams2016.Tree;


import java.util.*;

/**
 * 请设计一个算法，给一个字符串进行二进制编码，使得编码后字符串的长度最短。
 * 输入描述:
 * 每组数据一行，为待编码的字符串。保证字符串长度小于等于1000。
 * 输出描述:
 * 一行输出最短的编码后长度。
 * 示例1
 * 输入
 * 复制
 * MT-TECH-TEAM
 * 输出
 * 复制
 * 33
 */
public class CharacterEncoding {
    public static class TreeNode {
        int weight;
        TreeNode left;
        TreeNode right;

        TreeNode(int weight) {
            this.weight = weight;
        }
    }

    public static int getMinEncodingLength(String string) {
        char[] chars = string.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 1);
            }
        }
        PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            priorityQueue.add(new TreeNode(entry.getValue()));
        }
        while (priorityQueue.size() > 1) {
            TreeNode left = priorityQueue.poll();
            TreeNode right = priorityQueue.poll();
            TreeNode treeNode = new TreeNode(left.weight + right.weight);
            treeNode.left = left;
            treeNode.right = right;
            priorityQueue.add(treeNode);
        }
        TreeNode root = priorityQueue.poll();
        return getValLength(root, 0);
    }

    public static int getValLength(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return root.weight * depth;
        }
        return getValLength(root.left, depth + 1) + getValLength(root.right, depth + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            System.out.println(getMinEncodingLength(string));
        }
    }
}
