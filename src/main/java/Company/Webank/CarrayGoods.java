package Company.Webank;

import java.util.*;

/**
 * Created by rui on 2018/9/18.
 */
public class CarrayGoods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] goods = new int[7];
        for (int i = 1; i <= 6; i++) {
            goods[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 6; i >= 1; i--) {
            if (i == 6) {
                count += goods[6];
            }
            if (i == 5){
                count +=goods[5];
                if(goods[1] > goods[5]*11){
                    goods[1] -= goods[5]*11;
                }else{
                    goods[1] = 0;
                }
            }
            if (i == 4){
                count +=goods[4];
                goods[2]-=goods[4]*5;
                if (goods[2]<0){
                    goods[1]+=goods[2]*4;
                }
            }
            if (i == 3){
                count += (goods[3]+3)/4;
                if (goods[3]%4==1){
                    goods[2]-=5;
                    goods[1]-=7;
                }else if (goods[3]%4 ==2){
                    goods[2]-=3;
                    goods[1]-=6;
                }else if (goods[3]%4==1){
                    goods[1]-=1;
                    goods[1]-=5;
                }
            }
            if (i == 2){
                if (goods[2]<=0){
                    goods[1]+=goods[2]*4;
                }else{
                    count+=(goods[2]+8)/9;
                    if (goods[2]%9 != 0){
                        goods[1]-=(9-goods[2]%9)*4;
                    }
                }
            }
            if (i == 1){
                if (goods[1]>0){
                    count+=(goods[1]+35)/36;
                }
            }
        }
        System.out.println(count);
    }
}
