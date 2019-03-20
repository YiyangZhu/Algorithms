package UnionFind;

import java.util.HashMap;
import java.util.HashSet;

public class MostStonesRemovedTwo {
    public class TreeNode {
        TreeNode p;
        int[] a;
        int rank;

        public TreeNode() {

        }

        public TreeNode(int[] a) {
            this.a = a;
        }
    }

    HashSet<TreeNode> set;

    public int removeStones(int[][] stones) {
        this.set = new HashSet<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();

        for (int[] a : stones) {
            int i = a[0];
            int j = a[1];
            int[] a1 = {i, j};
            int index = a[0] * 531 + a[1];
            TreeNode t1 = new TreeNode(a1);
            map.put(index, t1);
            MAKE_SET(t1);
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
                    int index1 = i1 * 531 + j1;
                    int index2 = i2 * 531 + j2;
                    TreeNode t1 = FIND_SET(map.get(index1));
                    TreeNode t2 = FIND_SET(map.get(index2));
                    if (t1 != t2) {
                        UNION(t1, t2);
                    }
                }
            }
        }
        return stones.length - set.size();
    }

    private void MAKE_SET(TreeNode t1) {
        t1.p = t1;
        t1.rank = 0;
        set.add(t1);
    }

    private TreeNode FIND_SET(TreeNode t1) {
        if(t1 != t1.p){
            t1.p = FIND_SET(t1.p);
        }
        return t1.p;
    }

    private void UNION(TreeNode t1, TreeNode t2) {
        if(t1.rank > t2.rank){
            t2.p = t1;
            HashSet<TreeNode> newSet = new HashSet<>();
            for(TreeNode t: set){
                if(t != t2){
                    newSet.add(t);
                }
            }
            set = newSet;
        } else {
            t1.p = t2;
            if(t1.rank == t2.rank){
                t2.rank++;
            }
            HashSet<TreeNode> newSet = new HashSet<>();
            for(TreeNode t: set){
                if(t != t1){
                    newSet.add(t);
                }
            }
            set = newSet;
        }
    }
}