package LeetCode.String;

public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < name.length() || index2 < typed.length()) {
            if (index2 >= typed.length()){
                return false;
            }
            if (index1 < name.length() && index2 < typed.length() && name.charAt(index1) == typed.charAt(index2)) {
                index1++;
                index2++;
            } else {
                if (index2 > 0 && typed.charAt(index2) == typed.charAt(index2 - 1)) {
                    index2++;
                } else {
                    return false;
                }
            }
        }
        return index1 == name.length() && index2 == typed.length();
    }
}
