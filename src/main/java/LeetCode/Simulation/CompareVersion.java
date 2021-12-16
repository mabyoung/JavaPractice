package LeetCode.Simulation;

import java.util.LinkedList;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        LinkedList<Integer> list1 = form(version1);
        LinkedList<Integer> list2 = form(version2);
        int index = 0;
        while (index < list1.size() && index < list2.size()) {
            if (list1.get(index) < list2.get(index)) {
                return -1;
            } else if (list1.get(index) > list2.get(index)) {
                return 1;
            }
            index++;
        }
        if (index == list1.size()) {
            while (index < list2.size()) {
                if (list2.get(index++) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            while (index < list1.size()) {
                if (list1.get(index++) > 0) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public LinkedList<Integer> form(String version) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (String s : version.split("\\.")) {
            linkedList.addLast(Integer.parseInt(s));
        }
        return linkedList;
    }

    public static void main(String[] args) {
        CompareVersion compareVersion = new CompareVersion();
        System.out.println(compareVersion.compareVersion("0.1","1.1"));
    }
}
