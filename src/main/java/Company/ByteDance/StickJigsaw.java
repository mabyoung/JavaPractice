package Company.ByteDance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StickJigsaw {
    private static List<Integer> stickList = new ArrayList<>();
    private static void addStick(int action, int stickLength){
        if (action == 1){
            stickList.add(stickLength);
        } else if (action == 2){
            if (stickList.size()==0){
                return;
            }
            if (stickList.contains(stickLength)){
                Integer tmp = stickLength;
                stickList.remove(tmp);
            }
        } else {
            return;
        }
        Collections.sort(stickList);
        int sum = 0;
        for (int i = 0; i < stickList.size()-1;i++){
            sum += stickList.get(i);
        }
        if (sum <= stickList.get(stickList.size()-1)){
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i<n;i++){
            String[] split = scanner.nextLine().trim().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            addStick(a, b);
        }
    }
}
