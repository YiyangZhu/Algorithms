package UnionFind;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedTwo {
    public class TreeNode {
        int rank;
        TreeNode p;
    }

    int count;

    public int removeStones(int[][] stones) {
        count = 0;
        Map<Integer, TreeNode> rowMap = new HashMap<>();
        Map<Integer, TreeNode> colMap = new HashMap<>();
        for (int[] a : stones) {
            int i = a[0];
            int j = a[1];
            TreeNode t = new TreeNode();
            makeSet(t);
            if (rowMap.containsKey(i)) {
                TreeNode p1 = findSet(t);
                TreeNode p2 = findSet(rowMap.get(i));
                if (p1 != p2) {
                    union(p1, p2);
                }
            } else {
                rowMap.put(i, t);
            }
            if (colMap.containsKey(j)) {
                TreeNode p1 = findSet(t);
                TreeNode p2 = findSet(colMap.get(j));
                if (p1 != p2) {
                    union(p1, p2);
                }
            } else {
                colMap.put(j, t);
            }
        }
        return stones.length - count;
    }

    private void makeSet(TreeNode t) {
        t.rank = 0;
        t.p = t;
        count++;
    }

    private TreeNode findSet(TreeNode t) {
        if (t.p != t) {
            t.p = findSet(t.p);
        }
        return t.p;
    }

    private void union(TreeNode p1, TreeNode p2) {
        if (p1.rank > p2.rank) {
            p2.p = p1;
        } else {
            p1.p = p2;
            if (p1.rank == p2.rank) {
                p2.rank++;
            }
        }
        count--;
    }
}