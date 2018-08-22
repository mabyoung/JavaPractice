package SwordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    public static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : array) {
            if (map.containsKey(item)){
                map.put(item, map.get(item)+1);
            } else{
                map.put(item, 1);
            }
        }
        boolean flag = true;
        for (int item : array) {
            if (map.get(item) == 1){
                if (flag){
                    num1[0] = item;
                    flag = false;
                }else{
                    num2[0] = item;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,2,3,4};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]+"_"+num2[0]);
    }
}
