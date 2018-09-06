package Company.Huawei;

import java.util.*;

/**
 * Created by rui on 2018/9/5.
 */
class Item{
    public  String str;
    public  int num;
}
public class Yasuo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().trim().toCharArray();
        LinkedList<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        List<Item> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : input) {
            if (c>='0'&&c<='9'){
                if (count == 0){
                    count = count + c -'0';
                }else {
                    count = count * 10 +c-'0';
                }
            } else {
                if (count > 0){
                    Item item = new Item();
                    item.str = sb.toString();
                    item.num = count;
                    list.add(item);
                    count = 0;
                    sb.delete(0,sb.length());
                    sb.append(c);
                }else {
                    sb.append(c);
                }
            }
        }
        Item tmp = new Item();
        tmp.str = sb.toString();
        tmp.num = count;
        list.add(tmp);
        list.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.num != o2.num){
                    return o1.num-o2.num;
                }
                return o1.str.compareTo(o2.str);
            }
        });
        for (Item item : list) {
            for (int i=0;i<item.num;i++){
                System.out.print(item.str);
            }
        }

    }
}
