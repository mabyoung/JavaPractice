package LeetCode.Dynamic;

public class Candy {
    public int candy(int[] ratings) {
        int num = ratings.length;
        int[] candy = new int[num];
        for (int item : candy) {
            item = 1;
        }
        boolean flag1 = true;
        while(flag1){
            boolean flag2 = true;
            for (int i=0;i<num;i++){
                if (i-1>=0 && ratings[i-1]<ratings[i]){
                    candy[i] = candy[i-1]+1;
                    flag2=false;
                }
                if (i+1<num && ratings[i+1]<ratings[i]){
                    candy[i] = candy[i+1]+1;
                    flag2=false;
                }
            }
            if (flag2 == false){
                flag2 = true;
            }else{
                flag1 = false;
            }
        }
        int result = 0;
        for (int i : candy) {
            result+=i;
        }
        return result;
    }
}
