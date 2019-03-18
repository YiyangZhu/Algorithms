package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;

public class RedundantConnectionII {
    public static void main(String[] args) {
        RedundantConnectionII r = new RedundantConnectionII();
        r.demo();
    }

    private void demo() {
        int[][] a1 = {{1, 2}, {1, 3}, {2, 3}};
        findRedundantDirectedConnection(a1);
    }

    Map<Integer, Set<Integer>> map;
    List<int[]> result;
    Map<Integer, Integer> pMap;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        map = new HashMap<>();
        result = new ArrayList<>();
        pMap = new HashMap<>();
        for (int[] edge : edges) {
            buildMap(edge);
        }
        return result.get(0);
    }

    private void buildMap(int[] e) {
        int e0 = e[0];
        int e1 = e[1];
        if (!map.containsKey(e0) && !map.containsKey(e1)) {
            Set<Integer> set = new HashSet<>();
            set.add(e0);
            set.add(e1);
            map.put(e0, set);
            map.put(e1, set);
        } else if (map.containsKey(e0) && !map.containsKey(e1)) {
            Set<Integer> set = map.get(e0);
            set.add(e1);
            map.put(e1, set);
        } else if (!map.containsKey(e0) && map.containsKey(e1)) {
            Set<Integer> set = map.get(e1);
            set.add(e0);
            map.put(e0, set);
        } else if (map.get(e0) != map.get(e1)) {
            Set<Integer> set1 = map.get(e0);
            Set<Integer> set2 = map.get(e1);
            Set<Integer> merge = new HashSet<>();
            for (int i : set1) {
                merge.add(i);
            }
            for (int i : set2) {
                merge.add(i);
            }
            for (int i : merge) {
                map.put(i, merge);
            }
        } else {
            result.add(e);
        }
    }
}