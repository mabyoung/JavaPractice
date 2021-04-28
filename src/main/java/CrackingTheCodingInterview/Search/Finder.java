package CrackingTheCodingInterview.Search;

/**
 * 有一个排过序的数组，包含n个整数，但是这个数组向左进行了一定长度的移位，例如，原数组为[1,2,3,4,5,6]，
 * 向左移位5个位置即变成了[6,1,2,3,4,5],现在对于移位后的数组，需要查找某个元素的位置。请设计一个复杂度为log级别的算法完成这个任务。
 * 给定一个int数组A，为移位后的数组，同时给定数组大小n和需要查找的元素的值x，请返回x的位置(位置从零开始)。保证数组中元素互异。
 *
 * 有一个排过序的字符串数组，但是其中有插入了一些空字符串，请设计一个算法，找出给定字符串的位置。算法的查找部分的复杂度应该为log级别。
 * 给定一个string数组str,同时给定数组大小n和需要查找的string x，请返回该串的位置(位置从零开始)。
 */
public class Finder {
    public int findElement(int[] A, int n, int x) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == x) {
                return mid;
            }
            if (A[mid] < A[high]) {
                if (A[mid] < x && x <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (A[low] <= x && x < A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public int findString(String[] str, int n, String x) {
        int low = 0;
        int high = str.length - 1;
        while (low <= high) {
            while ("".equals(str[low]) && low <= high) {
                low++;
            }
            while ("".equals(str[high]) && low <= high){
                high--;
            }
            int mid = (low + high) / 2;
            int tmp = mid;
            while (tmp <= high && "".equals(str[tmp])) {
                tmp++;
            }
            if (str[tmp].compareTo(x) == 0) {
                return tmp;
            } else if (str[tmp].compareTo(x) < 0) {
                low = tmp + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Finder finder = new Finder();
        int result = finder.findString(new String[]{"a", "b", "", "c", "", "d"}, 6, "c");
        System.out.println(result);
    }
}
