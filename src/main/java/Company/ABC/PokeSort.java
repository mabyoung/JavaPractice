package Company.ABC;

import java.util.*;

public class PokeSort {
    public static void sort(String[] cards){
        Map<Character, Integer> decorMap = new HashMap<>();
        decorMap.put('k',1);
        decorMap.put('s',2);
        decorMap.put('h',3);
        decorMap.put('p',4);
        decorMap.put('q',5);
        List<String> list = Arrays.asList(cards);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer decor1 = decorMap.get(o1.charAt(0));
                Integer decor2 = decorMap.get(o2.charAt(0));
                if (decor1.equals(decor2)){
                    String num1 = o1.substring(1);
                    String num2 = o2.substring(1);
                    return Integer.parseInt(num1)-Integer.parseInt(num2);
                }else {
                    return decor1 - decor2;
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            cards[i]= list.get(i);
        }
    }

    public static void main(String[] args) {
        String[] cards = new String[]{"p5","k1","k2","s1","s3","h1","p2","p3"};
        sort(cards);
        for (String s : cards) {
            System.out.println(s);
        }
    }
}
