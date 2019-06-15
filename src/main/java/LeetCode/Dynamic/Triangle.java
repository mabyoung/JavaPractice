package LeetCode.Dynamic;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for (int i = triangle.size() - 1; i > 0; i--) {
            ArrayList<Integer> up = triangle.get(i-1);
            ArrayList<Integer> down = triangle.get(i);
            for (int j = 0;j<up.size();j++){
                up.set(j, up.get(j)+Math.min(down.get(j), down.get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        ArrayList<Integer> array1 = new ArrayList<>();
        array1.add(2);
        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(3);
        array2.add(4);
        ArrayList<Integer> array3 = new ArrayList<>();
        array3.add(6);
        array3.add(5);
        array3.add(7);
        ArrayList<Integer> array4 = new ArrayList<>();
        array4.add(4);
        array4.add(1);
        array4.add(8);
        array4.add(3);
        ArrayList<ArrayList<Integer>> array  = new ArrayList<>();
        array.add(array1);
        array.add(array2);
        array.add(array3);
        array.add(array4);
        System.out.println(triangle.minimumTotal(array));
    }
}
