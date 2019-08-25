package LeetCode.String;

public class LongestPalindromicSubstring {
    public class Item {
        int begin;
        int end;

        Item(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    public String longestPalindrome(String s) {
        Item result = new Item(0, 0);
        for (int i = 0; i < s.length(); i++) {
            Item palindrome = this.getPalindrome(s, i);
            this.compare(palindrome, result);
        }
        return s.substring(result.begin, result.end + 1);
    }

    private Item getPalindrome(String s, int index) {
        Item result = new Item(0, 0);
        if (index + 1 < s.length() && s.charAt(index) == s.charAt(index + 1)) {
            Item item = this.help(index, index + 1, s);
            this.compare(item, result);
        }
        Item item = this.help(index - 1, index + 1, s);
        this.compare(item, result);
        return result;
    }

    private void compare(Item item, Item result) {
        if (Math.abs(item.end - item.begin) > Math.abs(result.end - result.begin)) {
            result.end = item.end;
            result.begin = item.begin;
        }
    }

    private Item help(int i, int j, String s) {
        while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return new Item(i + 1, j - 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String result = longestPalindromicSubstring.longestPalindrome("abb");
        System.out.println(result);
    }
}
