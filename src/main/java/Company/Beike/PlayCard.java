package Company.Beike;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rui on 2018/8/18.
 */
public class PlayCard{
    public static List<Integer> cards = new ArrayList<>();
    public static void sunzi(){
        int ok;
        Integer begin = cards.get(0);
        int index = begin+1;
        int sum = 1;
        for (Integer card : cards) {
            if (card == index){
                sum++;
                index++;
            }
        }
        if (sum>=5){
            for (int i=0;i<sum;i++){
                cards.remove((Integer)(i+begin));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().trim().toCharArray();

        for (char c : input) {
            if (c == 'A'){
                cards.add(1);
            }else if (c=='T'){
                cards.add(10);
            }else if (c=='J'){
                cards.add(11);
            }else if (c=='Q'){
                cards.add(12);
            }else if (c=='K'){
                cards.add(13);
            }else{
                String s = ""+c;
                cards.add(Integer.parseInt(s));
            }
        }
        cards.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        sunzi();
        for (Integer card : cards) {
            System.out.println(card);
        }

    }
}
