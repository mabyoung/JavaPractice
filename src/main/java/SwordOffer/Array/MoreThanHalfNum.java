package SwordOffer.Array;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 思路：如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
 * 在遍历数组时保存两个值：一是数组中一个数字，一是次数。
 * 遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，则保存下一个数字，并将次数置为1。
 * 遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
 */
public class MoreThanHalfNum {
    public static int moreThanHalfNum(int[] array) {
        int result = 0;
        int count = 0;
        for (int item : array) {
            if (item == result) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                result = item;
                count = 1;
            }
        }
        count = 0;
        for (int item : array) {
            if (item == result) {
                count++;
            }
        }
        return count > array.length / 2 ? result : 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(moreThanHalfNum(array));
    }
}
