package LeetCode.Simulation;

import java.util.*;

public class LockingTree {
    Map<Integer, Integer> parentMap = new HashMap<>();
    Map<Integer, List<Integer>> childMap = new HashMap<>();
    Map<Integer, Integer> lockMap = new HashMap<>();

    public LockingTree(int[] parent) {
        for (int i = 1; i < parent.length; i++) {
            List<Integer> childValue = childMap.get(parent[i]);
            if (childValue == null) {
                childValue = new ArrayList<>();
            }
            childValue.add(i);
            childMap.put(parent[i], childValue);
            parentMap.put(i, parent[i]);
        }
    }

    public boolean lock(int num, int user) {
        Integer value = lockMap.get(num);
        if (value == null) {
            lockMap.put(num, user);
            return true;
        } else {
            return false;
        }
    }

    public boolean unlock(int num, int user) {
        Integer value = lockMap.get(num);
        if (value == null || value != user) {
            return false;
        } else {
            lockMap.remove(num);
            return true;
        }
    }

    public boolean upgrade(int num, int user) {
        if (lockMap.get(num) != null) {
            return false;
        }
        if (!haveLockedChild(num)) {
            return false;
        }
        if (haveLockedParent(num)) {
            return false;
        }
        lockMap.put(num, user);
        unlockChild(num);
        return true;
    }

    public void unlockChild(int num) {
        List<Integer> childList = childMap.get(num);
        if (childList == null) {
            return;
        }
        for (Integer child : childList) {
            lockMap.remove(child);
            unlockChild(child);
        }
    }

    public boolean haveLockedChild(int num) {
        List<Integer> childList = childMap.get(num);
        if (childList == null) {
            return false;
        }
        for (Integer child : childList) {
            if (lockMap.get(child) != null) {
                return true;
            } else {
                if (haveLockedChild(child)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean haveLockedParent(int num) {
        Integer parent = parentMap.get(num);
        while (parent != null) {
            if (lockMap.get(parent) != null) {
                return true;
            }
            parent = parentMap.get(parent);
        }
        return false;
    }
}
