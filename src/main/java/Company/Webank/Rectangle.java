package Company.Webank;

import java.util.*;

/**
 * 阳阳突发奇想画起了三角！

 1/1(1)  1/2(2)  1/3(6)  1/4(7) ...

 2/1(3)  2/2(5)  2/3(8) ...

 3/1(4)  3/2(9) ...

 4/1(10) ...

 ...

 并且在三角每个位置填上了一个数字（即分数后括号中的数字），然后按照z字型给数字了一个编号，如上图所示。

 现在阳阳想知道编号为N的数字是多少，希望你能够告诉他。

 1≤N≤10000000
 */
public class Rectangle {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String GetResult(int N) {
        int index = 1;
        while(N>index){
            N-=index;
            index++;
        }
        if(index %2 ==1){
            return ""+(index+1-N)+"/"+N;
        }else{
            return ""+N+"/"+(index+1-N);
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _N;
        _N = Integer.parseInt(in.nextLine().trim());

        res = GetResult(_N);
        System.out.println(res);
    }
}

