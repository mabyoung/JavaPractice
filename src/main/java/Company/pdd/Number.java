package Company.pdd;


import java.util.*;

/**
 * Created by rui on 2018/8/30.
 */
public class Number {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        ArrayList<Integer> t1 = new ArrayList<>();
        ArrayList<Integer> t2 = new ArrayList();
        int s = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = -1;
        while (true) {
            t1.add(a / b);
            int x = a % b;
            if (x == 0) {
                break;
            }
            if (hm.get(x) != null) {
                s = hm.get(x);
            } else {
                s = -1;
            }
            if (s >= 0) {
                break;
            } else {
                hm.put(x, ++count);
            }
            a = x * 10;
        }
        if (s >= 0)
            System.out.println(s + " " + (t1.size() - 1 - s));
        else
            System.out.println((t1.size() - 1) + " " + 0);
    }

}
