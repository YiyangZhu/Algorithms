package UnionFind;

import java.util.HashSet;

public class MostStonesRemoved {
    HashSet<HashSet<int[]>> set;

    public int removeStones(int[][] stones) {
        set = new HashSet<>();
        int m = 0;
        int n = 0;
        for (int[] a : stones) {
            MAKE_SET(a);
            if (m < a[0]) {
                m = a[0];
            }
            if (n < a[1]) {
                n = a[1];
            }
        }
        for (int i = 0; i < stones.length - 1; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                int[] a1 = stones[i];
                int[] a2 = stones[j];
                int i1 = a1[0];
                int j1 = a1[1];
                int i2 = a2[0];
                int j2 = a2[1];
                if (i1 == i2 || j1 == j2) {
                    HashSet<int[]> s1 = FIND_SET(a1);
                    HashSet<int[]> s2 = FIND_SET(a2);
                    if (s1 != s2) {
                        UNION(s1, s2);
                    }
                }
            }
        }
        return stones.length - set.size();
    }

    private void MAKE_SET(int[] a) {
        HashSet set1 = new HashSet<>();
        set1.add(a);
        set.add(set1);
    }

    private HashSet<int[]> FIND_SET(int[] a) {
        for (HashSet<int[]> s : set) {
            for (int[] a1 : s) {
                if (a1[0] == a[0] && a1[1] == a[1]) {
                    return s;
                }
            }
        }
        return null;
    }

    private void UNION(HashSet<int[]> s1, HashSet<int[]> s2) {
        s1.addAll(s2);
        HashSet<HashSet<int[]>> newSet = new HashSet<>();
        for (HashSet<int[]> s : set) {
            if (s != s2) {
                newSet.add(s);
            }
        }
        set = newSet;
    }
}

