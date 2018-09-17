package Company.Tencent;
import java.util.*;
/**
 * Created by rui on 2018/9/16.
 */
public class NiuNiu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-->0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            boolean flag = false;
            for(int i=1;i<=b;i++){
                if (a*i % b == c){
                    flag = true;
                    break;
                }
            }
            if (flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
