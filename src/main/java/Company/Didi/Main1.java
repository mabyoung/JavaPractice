package Company.Didi;
import java.util.*;
/**
 * Created by rui on 2018/9/18.
 */
class Word{
    char[] content;
    int cost;
    public Word(String content){
        this.content = content.toCharArray();
    }
}
public class Main1 {
    private static int[][] LCSPath;
    private static Set<Character> set1 = new HashSet<>();
    private static Set<Character> set2 = new HashSet<>();
    public static int getLCSLength(char[]a, char[]b){
        int[][] LCS = new int[a.length+1][b.length+1];
        LCSPath = new int[a.length][b.length];
        for (int index = 0; index < a.length; index++){
            LCS[index][0] = 0;
        }
        for (int index = 0; index < b.length; index++){
            LCS[0][index] = 0;
        }
        for (int i = 1; i <= a.length; i++){
            for (int j = 1; j <= b.length; j++){
                if (a[i-1] == b[j-1]){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                    LCSPath[i-1][j-1] = 2;
                } else {
                    if (LCS[i-1][j] > LCS[i][j-1]){
                        LCS[i][j] = LCS[i-1][j];
                        LCSPath[i-1][j-1] = 1;
                    } else {
                        LCS[i][j] = LCS[i][j-1];
                        LCSPath[i-1][j-1] = 3;
                    }
                }
            }
        }
        return LCS[a.length][b.length];
    }
    public static List<Character> getLCS(char[]a, char[]b){
        Stack<Character> stack = new Stack<>();
        int i = a.length-1, j = b.length -1;
        while(i >= 0 && j >= 0){
            int lastPath = LCSPath[i][j];
            if (lastPath == 1){
                i--;
            } else if (lastPath == 2){
                stack.push(a[i]);
                i--;j--;
            } else if (lastPath == 3){
                j--;
            }
        }
        List<Character> result = new ArrayList<>();
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
    public static int getCost(char a, char b){
        if (a == b){
            return 0;
        }
        if (set1.contains(a) && set2.contains(b)){
            return 2;
        }else if (set2.contains(a) && set1.contains(b)){
            return 2;
        }else {
            return 1;
        }
    }
    public static int getCost(char[] from, char[] target){
        int lcsLength = getLCSLength(from, target);
        List<Character> lcs = getLCS(from, target);
        if (from.length == target.length){
            if (lcsLength == from.length){
                return 0;
            }else{
                int count = 0;
                for (int i=0;i<from.length;i++){
                    count += getCost(from[i],target[i]);
                }
                return count;
            }
        }else{
            if (lcsLength == Math.min(from.length, target.length)){
                return Math.abs(from.length-target.length)*3;
            }
            return Math.abs(from.length-target.length)*3;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(" ");
        char[] target = split[0].toCharArray();
        List<Word> wordList = new ArrayList<>();
        set1.add('q');set1.add('w');set1.add('e'); set1.add('r'); set1.add('t'); set1.add('a'); set1.add('v'); set1.add('d');
        set1.add('f'); set1.add('g'); set1.add('z');set1.add('x');set1.add('c');set1.add('v');
        set2.add('y');set2.add('u');set2.add('i');set2.add('o');set2.add('p');set2.add('h');set2.add('j');set2.add('k');
        set2.add('l');set2.add('b');set2.add('n');set2.add('m');
        for (int i=1;i<split.length;i++){
            Word word = new Word(split[i]);
            word.cost = getCost(word.content, target);
            wordList.add(word);
        }
        wordList.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.cost-o2.cost;
            }
        });
        for (int i=0;i<3;i++){
            char[] content = wordList.get(i).content;
            for (int j=0;j<content.length;j++){
                System.out.print(content[j]);
            }
            System.out.println();
        }
    }
}
