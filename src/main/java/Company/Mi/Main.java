package Company.Mi;

import java.util.*;

public class Main {
    static int max = 0;

    static int calculateHelper(int[] array) {
        int max = 0;
        int max_pos = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                max_pos = i;
            }
        }

        int max_left = 0;
        int max_right = 0;
        int volume = 0;

        for (int i = 0; i < max_pos; i++) {
            if (max_left < array[i]) {
                max_left = array[i];
            } else {
                volume += (max_left - array[i]);
            }
        }

        for (int j = array.length - 1; j > max_pos; j--) {
            if (max_right < array[j]) {
                max_right = array[j];
            } else {
                volume += (max_right - array[j]);
            }
        }
        return volume;

    }

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int findMaxCapacity(int[] array, int m) {
        if (m > 0){
            for (int i = 0; i < array.length; i++) {
                array[i]++;
                findMaxCapacity(array, m - 1);
                array[i]--;
            }
        } else {
            int sum = calculateHelper(array);
            if (max < sum){
                max = sum;
            }
        }
        return max;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _array_size = 0;
        _array_size = Integer.parseInt(in.nextLine().trim());
        int[] _array = new int[_array_size];
        int _array_item;
        for (int _array_i = 0; _array_i < _array_size; _array_i++) {
            _array_item = Integer.parseInt(in.nextLine().trim());
            _array[_array_i] = _array_item;
        }

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        res = findMaxCapacity(_array, _m);
        System.out.println(String.valueOf(res));

    }
}

