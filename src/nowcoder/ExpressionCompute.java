package nowcoder;

import java.util.LinkedList;
import java.util.Scanner;

public class ExpressionCompute {

    private static int getValue(String str){
        return value(str.toCharArray(), 0)[0];
    }

    private static int[] value(char[] str, int i){
        LinkedList<String> que = new LinkedList<>();
        int number = 0;
        while (i < str.length && str[i] != ')'){
            if (str[i] >= '0' && str[i] <= '9'){
                number = number * 10 + str[i++] - '0';
            } else if (str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/'){
                addNum(que, number);
                que.addLast(String.valueOf(str[i++]));
                number = 0;
            } else if (str[i] == '('){
                int[] bra = value(str, i+1);
                number = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(que, number);
        return new int[] {getNum(que), i};
    }

    private static void addNum(LinkedList<String> que, int num){
        if (!que.isEmpty()){
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")){
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    private static int getNum(LinkedList<String> que){
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while(!que.isEmpty()){
            cur = que.pollFirst();
            if (cur.equals("+")){
                add = true;
            } else if (cur.equals("-")){
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String trim = scanner.nextLine().trim();
        int value = getValue(trim);
        System.out.println(value);
    }
}
