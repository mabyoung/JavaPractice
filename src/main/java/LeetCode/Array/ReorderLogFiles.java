package LeetCode.Array;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] splits1 = o1.split(" ", 2);
                String[] splits2 = o2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(splits1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(splits2[1].charAt(0));
                if (isDigit1 && isDigit2){
                    return 0;
                }else if (isDigit1){
                    return 1;
                }else if (isDigit2){
                    return -1;
                }else{
                    if (splits1[1].equals(splits2[1])){
                        return splits1[0].compareTo(splits2[0]);
                    }else{
                        return splits1[1].compareTo(splits2[1]);
                    }
                }
            }
        });
        return logs;
    }

}
