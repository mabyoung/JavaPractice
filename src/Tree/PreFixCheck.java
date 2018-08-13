package Tree;

import java.util.HashMap;

public class PreFixCheck {
    public static class Tries {
        private HashMap<Character, Tries> children = new HashMap<>();
        private boolean end = false;

        public boolean addAndCheck(char[] chs, int i){
            if (end){
                return true;
            }
            if (i == chs.length){
                end = true;
                return !children.isEmpty();
            }
            if (!children.containsKey(chs[i])){
                children.put(chs[i], new Tries());
            }
            return children.get(chs[i]).addAndCheck(chs, i+1);
        }
    }
    public static boolean hasPrefix(String[] strs){
        Tries tries = new Tries();
        for (String str : strs) {
            if (str == null || str.equals("")){
                return true;
            }
            char[] chars = str.toCharArray();
            boolean result = tries.addAndCheck(chars, 0);
            if (result){
                return result;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "abecd";
        String[] strings = new String[2];
        strings[0] = str1;
        strings[1] = str2;
        System.out.println(hasPrefix(strings));
    }
}
