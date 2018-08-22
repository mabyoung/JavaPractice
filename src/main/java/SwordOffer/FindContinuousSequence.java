package SwordOffer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = (int) Math.floor(Math.sqrt(2 * sum)); i >= 2; i--) {
            double pirot = (double) sum / i;
            if ((int) pirot == pirot && i % 2 == 1) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int j = (int) (pirot - i / 2); j <= (int) (pirot + i / 2); j++) {
                    tmp.add(j);
                }
                result.add(tmp);
            } else if ((int) pirot != pirot && (int) (pirot * 2) == pirot * 2 && i % 2 == 0) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int j = (int) (pirot - i / 2 + 1); j <= (int) (pirot + i / 2); j++) {
                    tmp.add(j);
                }
                result.add(tmp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> continuousSequence = findContinuousSequence(9);
        for (ArrayList<Integer> integers : continuousSequence) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
