package Company.Beike;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map.put(a,b);
        }
        n = scanner.nextInt();
        boolean aflag,bflag;
        for (int i = 0;i<n;i++){
            aflag = true;
            bflag = true;
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int aFather = a;
            int bFather = b;
            while (map.containsKey(aFather)){
                if (aFather == b){
                    System.out.println(2);
                    aflag = false;
                    break;
                }
                aFather = map.get(aFather);
            }
            while (map.containsKey(bFather)){
                if (bFather == a){
                    System.out.println(1);
                    bflag = false;
                    break;
                }
                bFather = map.get(bFather);
            }
            if (aflag&&bflag){
                System.out.println(0);
            }
        }
    }
}
