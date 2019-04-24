package Coderwars.Kyu6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WhichAreIn {
    public static String[] inArray(String[] array1, String[] array2) {
        List<String> array1List = new ArrayList<>();
        for (String s1 : array1) {
            for (String s2 : array2) {
                if (s2.contains(s1)){
                    array1List.add(s1);
                    break;
                }
            }
        }
        array1List.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String[] result = new String[array1List.size()];
        int i = 0;
        for (String s : array1List) {
            result[i++] = s;
        }
        return result;
    }

    public static void main(String[] args) {
        String a[] = new String[]{ "arp", "live", "strong" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        System.out.println(inArray(a, b));
    }
}
