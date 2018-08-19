package SwordOffer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectangularCover {
    public static int rectangularCover(int target){
        if (target == 0){
            return 0;
        } else if (target == 1){
            return 1;
        } else if (target == 2){
            return 2;
        } else {
            return rectangularCover(target-1)+rectangularCover(target-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(rectangularCover(3));
    }
}
