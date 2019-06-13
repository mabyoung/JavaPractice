package LeetCode.Dynamic;

import java.util.ArrayList;

public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<String> current = new ArrayList<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        dfs(s, current, result);
        return result;
    }

    public void dfs(String s, ArrayList<String> current, ArrayList<ArrayList<String>> result) {
        if (s == null || s.equals("")){
            ArrayList<String> tmp = new ArrayList<>(current);
            result.add(tmp);
        }else{
            for (int i = 1;i<=s.length();i++){
                String substring = s.substring(0, i);
                if (isPalindrome(substring)){
                    current.add(substring);
                    dfs(s.substring(i), current, result);
                    current.remove(current.size()-1);
                }
            }
        }
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        ArrayList<ArrayList<String>> result = palindromePartitioning.partition("aabb");
        for (ArrayList<String> strings : result) {
            System.out.println(strings);
        }
    }
}
