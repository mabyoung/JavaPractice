package SwordOffer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增，每一列都按照从上到下递增。判断数组中是否含有某个整数。
 */
public class FindTargetInTheArray {
    public static boolean find(int target, int [][] array) {
        int row = array.length;
        int column = array[0].length;
        int i = 0;
        int j = column-1;
        while(i<=row-1 && j>=0){
            if(array[i][j] == target){
                return true;
            }else if(array[i][j] < target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int [][] array = {{1,2,3},{2,3,4},{3,4,5}};
        System.out.println(find(8,array));
    }
}
