package SwordOffer;

import java.util.*;

public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str){
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int index = -1;
        for (int i=0;i<chars.length;i++){
            if (map.get(chars[i]) == 1){
                index = i;
                break;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int i = firstNotRepeatingChar(str);
        System.out.println(i);
    }
}
