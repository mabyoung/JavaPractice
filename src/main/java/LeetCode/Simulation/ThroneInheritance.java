package LeetCode.Simulation;

import Company.Envision.Tree;

import java.util.*;

public class ThroneInheritance {
    Map<String, List<String>> edges = new HashMap<>();
    Set<String> death = new HashSet<>();
    String king;

    public ThroneInheritance(String kingName) {
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        if (edges.containsKey(parentName)){
            edges.get(parentName).add(childName);
        }else{
            List<String> list = new ArrayList<>();
            list.add(childName);
            edges.put(parentName, list);
        }
    }

    public void death(String name) {
        death.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        getInheritanceOrder(king, result);
        return result;
    }

    public void getInheritanceOrder(String cursor, List<String> list){
        if (!death.contains(cursor)){
            list.add(cursor);
        }
        List<String> child = edges.get(cursor);
        if (child == null){
            return;
        }
        for (String s : child) {
            getInheritanceOrder(s, list);
        }
    }
}
