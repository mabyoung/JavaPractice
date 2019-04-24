package Coderwars.Kyu6;
/* Given two arrays a and b write a function comp(a, b) (compSame(a, b) in Clojure) that checks whether the two arrays
 * have the "same" elements, with the same multiplicities. "Same" means, here, that the elements in b are the elements
 * in a squared, regardless of the order.
 */

import java.util.ArrayList;
import java.util.List;

public class AreSame {
    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0){
            return false;
        }
        if (b.length == 0){
            return true;
        }
        List<Integer> c = new ArrayList<>();
        for (int item : a) {
            c.add(item*item);
        }
        for (int item : b) {
            if (!c.contains(item)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 36100, 25921, 361, 20736, 361};
        System.out.println(comp(a, b));
    }
}
