package SwordOffer;

/**
 * Created by rui on 2018/8/18.
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
