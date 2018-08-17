package Company.Net163;

import java.util.Scanner;

/**
 * Created by rui on 2018/8/11.
 */
public class findApple {
    private static int appleStack[];
    private static int n;
    private static void findApple(int key){
        int low = 0,high =n-1,mid;
        while(low <=high){
            mid = (low +high)/2;
            if (appleStack[mid] == key){
                System.out.println(mid+1);
                return;
            }else if (mid-1>=0 && appleStack[mid-1]<key &&appleStack[mid]>key){
                System.out.println(mid+1);
                return;
            }else if (mid == 0 && appleStack[mid]>key){
                System.out.println(mid+1);
                return;
            }
            else if (appleStack[mid]<key){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        appleStack = new int[n];
        appleStack[0]=scanner.nextInt();
        for (int i = 1; i<n;i++){
            appleStack[i]=appleStack[i-1]+scanner.nextInt();
        }
        int m = scanner.nextInt();
        int key[] = new int[m];
        for (int i=0;i<m;i++){
            key[i] = scanner.nextInt();
        }
        for (int i=0;i<m;i++){
            findApple(key[i]);
        }
    }
}
