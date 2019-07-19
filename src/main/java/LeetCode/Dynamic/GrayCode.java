package LeetCode.Dynamic;

import java.util.ArrayList;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int pow_2_i = 1 << i;
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(result.get(j) + pow_2_i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        ArrayList<Integer> result = grayCode.grayCode(10);
        System.out.println(result);
    }
}
