package SwordOffer.Array;

import java.util.HashMap;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 思路：不需要额外的数组或者hash table来保存，题目里写了数组里数字的范围保证在0 ~ n-1 之间，所以可以利用现有数组设置标志。
 * 当一个数字被访问过后，可以设置对应位上的数 + n。
 * 之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
 */
public class Duplicate {
    public static boolean solution1(int numbers[], int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            if (map.containsKey(number)) {
                duplication[0] = number;
                return true;
            } else {
                map.put(number, 1);
            }
        }
        return false;
    }

    public static boolean solution2(int numbers[], int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int number = numbers[i];
            if (number >= length) {
                number -= length;
            }
            if (numbers[number] > length) {
                duplication[0] = number;
                return true;
            } else {
                numbers[number] += length;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[] array = "https://www.guazi.com/".toCharArray();
        System.out.println(array.length);
        int[] numbers = {2, 1, 3, 1, 4};
        int[] duplication = new int[1];
        if (solution2(numbers, duplication)) {
            System.out.println(duplication[0]);
        }
    }
}
