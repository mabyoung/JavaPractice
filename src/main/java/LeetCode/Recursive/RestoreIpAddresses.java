package LeetCode.Recursive;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given"25525511135",
 *
 * return["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIpAddresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        if (s == null){
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> dotIndex = new ArrayList<>();
        dotIndex.add(0);
        dfs(s, dotIndex, result);
        return result;
    }

    public void dfs(String s, ArrayList<Integer> dotIndex, ArrayList<String> result) {
        Integer lastDotIndex = dotIndex.get(dotIndex.size() - 1);
        if (dotIndex.size() == 4) {
            String sub = s.substring(lastDotIndex);
            if (!(sub.length() > 1 && sub.charAt(0) == '0') && sub.length() <= 3 && Integer.parseInt(sub) >= 0 && Integer.parseInt(sub) <= 255) {
                s = s.substring(dotIndex.get(0), dotIndex.get(1)) + "." + s.substring(dotIndex.get(1), dotIndex.get(2)) +
                        "." + s.substring(dotIndex.get(2), dotIndex.get(3)) + "." + s.substring(dotIndex.get(3));
                result.add(s);
            }
        } else if (dotIndex.size() < 4){
            for (int i = lastDotIndex + 1; i < s.length(); i++) {
                String sub = s.substring(lastDotIndex, i);
                if (!(sub.length() > 1 && sub.charAt(0) == '0') && sub.length() <= 3 && Integer.parseInt(sub) >= 0 && Integer.parseInt(sub) <= 255) {
                    dotIndex.add(i);
                    dfs(s, dotIndex, result);
                    dotIndex.remove(Integer.valueOf(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        ArrayList<String> result = restoreIpAddresses.restoreIpAddresses("010010");
        System.out.println(result);
    }
}
