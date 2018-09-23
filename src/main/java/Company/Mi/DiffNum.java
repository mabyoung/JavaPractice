package Company.Mi;
import java.util.*;
/**
 * Created by rui on 2018/9/20.
 */
public class DiffNum {
    public static int getNum(String num, int heavy){
        char[] chars = num.toCharArray();
        int result = 0;
        int bias = 1;
        for (int i=chars.length-1;i>=0;i--){
            if (chars[i]>='0'&&chars[i]<='9'){
                result += (chars[i]-'0')*bias;
            }else if (chars[i]>='a'&&chars[i]<='z'){
                result += (chars[i]-'a'+10)*bias;
            }else if (chars[i]>='A'&&chars[i]<='Z'){
                result += (chars[i]-'A'+10)*bias;
            }
            bias*=heavy;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        String tmp;
        while(!(tmp=scanner.nextLine()).equals("END")){
            input.add(tmp);
        }
        for (String item : input) {
            String[] split = item.split("#");
            int num = getNum(split[1], Integer.parseInt(split[0]));
            if (map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        boolean flag = true;
        for (String item : input) {
            String[] split = item.split("#");
            int num = getNum(split[1], Integer.parseInt(split[0]));
            if (map.get(num) == 1){
                System.out.println(item);
                flag = false;
            }
        }
        if (flag){
            System.out.println("None");
        }
    }
}
