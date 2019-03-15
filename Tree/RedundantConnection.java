package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class RedundantConnection {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Set<Integer>> map;

    public int[] findRedundantConnection(int[][] edges) {
        map = new HashMap<>();
        for (int[] array : edges) {
            int i = array[0];
            int j = array[1];
            if (map.containsKey(i) && map.containsKey(j) && map.get(i) == map.get(j)) {
                return array;
            } else {
                buildSet(i, j);
            }
        }
        return edges[edges.length - 1];
    }

    private void buildSet(int i, int j) {
        if (map.containsKey(i) && map.containsKey(j)) {
            Set<Integer> set1 = map.get(i);
            Set<Integer> set2 = map.get(j);
            Set<Integer> mergeSet = new HashSet<>();
            for (int k1 : set1) {
                mergeSet.add(k1);
            }
            for (int k1 : set2) {
                mergeSet.add(k1);
            }
            for (int k1 : mergeSet) {
                map.put(k1, mergeSet);
            }
            return;
        }
        if (map.containsKey(i)) {
            Set<Integer> set = map.get(i);
            set.add(j);
            map.put(j, set);
            return;
        }
        if (map.containsKey(j)) {
            Set<Integer> set = map.get(j);
            set.add(i);
            map.put(i, set);
            return;
        }
        Set<Integer> set = new HashSet<>();
        set.add(i);
        set.add(j);
        map.put(i, set);
        map.put(j, set);
    }
}
