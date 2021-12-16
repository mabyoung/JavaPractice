package LeetCode.String;

public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        char firstChar = word.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            return isAllLowerCase(word);
        } else {
            return isAllLowerCase(word.substring(1)) || isAllUpperCase(word);
        }
    }

    private boolean isAllLowerCase(String word) {
        for (char item : word.toCharArray()) {
            if (item < 'a' || item > 'z') {
                return false;
            }
        }
        return true;
    }

    private boolean isAllUpperCase(String word) {
        for (char item : word.toCharArray()) {
            if (item < 'A' || item > 'Z') {
                return false;
            }
        }
        return true;
    }
}
