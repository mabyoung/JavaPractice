package Company.Ctrip;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rui on 2018/9/4.
 */
public class HotelRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        List<Integer> result = new ArrayList<>();
        for (int i= 0;i<n;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (b<=target&&c>=target){
                result.add(a);
            }
        }
        if (result.size()==0){
            System.out.println("null");
        }else {
            result.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            for (int i=0;i<result.size();i++){
                System.out.println(result.get(i));
            }
        }
    }
}
