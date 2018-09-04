package Company.Beike;

import Company.Qihoo360.Array;

import java.util.*;

/**
 * Created by rui on 2018/9/3.
 */
public class Card {
    static class Dcard {
        int x;
        int h;
        int max;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Dcard> list = new ArrayList<>(n);
        for (int i=0;i<n;i++){
            Dcard card = new Dcard();
            card.x = scanner.nextInt();
            card.h = scanner.nextInt();
        }
        list.sort(new Comparator<Dcard>() {
            @Override
            public int compare(Dcard o1, Dcard o2) {
                return o1.x - o2.x;
            }
        });
        for (Dcard card : list) {

        }
        int count = 0,a,b;
    }
}
