package UnionFind;

import java.util.HashMap;

public class MostStonesRemovedTwo {
    public class TreeNode {
        TreeNode p;
        int index;
        int rank;

        public TreeNode() {

        }

        public TreeNode(int i) {
            this.index = i;
        }
    }

    int count;

    public int removeStones(int[][] stones) {
        count = 0;
        HashMap<Integer, TreeNode> rowMap = new HashMap<>();
        HashMap<Integer, TreeNode> colMap = new HashMap<>();

        for (int[] a : stones) {
            int i = a[0];
            int j = a[1];
            int[] a1 = {i, j};
            int index = a[0] * 531 + a[1];
            TreeNode t1 = new TreeNode(index);
            MAKE_SET(t1);
            if (rowMap.containsKey(i)) {
                TreeNode t2 = rowMap.get(i);
                TreeNode p1 = FIND_SET(t1);
                TreeNode p2 = FIND_SET(t2);
                if (p1 != p2) {
                    UNION(p1, p2);
                }
            } else {
                rowMap.put(i, t1);
            }

            if (colMap.containsKey(j)) {
                TreeNode t2 = colMap.get(j);
                TreeNode p1 = FIND_SET(t1);
                TreeNode p2 = FIND_SET(t2);
                if (p1 != p2) {
                    UNION(p1, p2);
                }
            } else {
                colMap.put(j, t1);
            }
        }
        return stones.length - count;
    }

    private void MAKE_SET(TreeNode t1) {
        t1.p = t1;
        t1.rank = 0;
        count++;
    }

    private TreeNode FIND_SET(TreeNode t1) {
        if (t1 != t1.p) {
            t1.p = FIND_SET(t1.p);
        }
        return t1.p;
    }

    private void UNION(TreeNode t1, TreeNode t2) {
        if (t1.rank > t2.rank) {
            t2.p = t1;
        } else {
            t1.p = t2;
            if (t1.rank == t2.rank) {
                t2.rank++;
            }
        }
        count--;
    }
}