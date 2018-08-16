package DataStructure.recursion;

import java.util.LinkedList;

public class ExpressionCompute {
    public static int getValue(String str){
        return value(str.toCharArray(), 0)[0];
    }

    public static int[] value(char[] str, int i){
        LinkedList<String> que = new LinkedList<>();
        int pre = 0;
        int[] bra = null;
        while (i < str.length && str[i] != ')'){
            if (str[i] >= '0' && str[i] <= '9'){
                pre = pre * 10 + str[i++] - '0';
            } else if (str[i] != '('){
//                addNum(que, pre);
                que.addLast(String.valueOf(str[i++]));
                pre = 0;
            } else {
                bra = value(str,  i+1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
//        addNum(que, pre);
        return null;
    }

}
