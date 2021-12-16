package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(dealEmail(email));
        }
        return set.size();
    }

    public String dealEmail(String email) {
        String[] split = email.split("@");
        String name = split[0].split("\\+")[0];
        String address = split[1];
        return name.replace(".", "") + "@" + address;
    }

    public static void main(String[] args) {
        NumUniqueEmails numUniqueEmails = new NumUniqueEmails();
        System.out.println(numUniqueEmails.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }
}
