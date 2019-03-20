package UnionFind;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetForest {
    public class TreeNode {
        char c;
        TreeNode p;
        int rank;

        public TreeNode() {

        }

        public TreeNode(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        DisjointSetForest d = new DisjointSetForest();
        d.demo();
    }

    private void demo() {
        TreeNode f1 = new TreeNode('f');
        TreeNode e1 = new TreeNode('e');
        TreeNode d1 = new TreeNode('d');
        TreeNode c1 = new TreeNode('c');
        TreeNode b1 = new TreeNode('b');
        TreeNode a1 = new TreeNode('a');

        f1.p = f1;
        e1.p = f1;
        d1.p = e1;
        c1.p = d1;
        b1.p = c1;
        a1.p = b1;

        List<TreeNode> set = new ArrayList<>();
        set.add(f1);
        set.add(e1);
        set.add(d1);
        set.add(c1);
        set.add(b1);
        set.add(a1);
        System.out.println("Before path compression");
        printSet(set);
        for (TreeNode t : set) {
            FIND_SET(t);
        }
        System.out.println("\nAfter path compression");
        printSet(set);

        System.out.println();

        TreeNode c2 = new TreeNode('c');
        TreeNode h2 = new TreeNode('h');
        TreeNode b2 = new TreeNode('b');
        TreeNode e2 = new TreeNode('e');
        TreeNode f2 = new TreeNode('f');
        TreeNode d2 = new TreeNode('d');
        TreeNode g2 = new TreeNode('g');

        b2.p = h2;
        h2.p = c2;
        e2.p = c2;
        c2.p = c2;
        g2.p = d2;
        d2.p = f2;
        f2.p = f2;

        List<TreeNode> set2 = new ArrayList<>();
        set2.add(b2);
        set2.add(h2);
        set2.add(e2);
        set2.add(c2);
        set2.add(g2);
        set2.add(d2);
        set2.add(f2);
        System.out.println("Before union by rank and path compression");
        printSet(set2);
        for (int i = 0; i < set2.size() - 1; i++) {
            for (int j = i + 1; j < set2.size(); j++) {
                UNION(set2.get(i), set2.get(j));
            }
        }
        System.out.println("\nAfter union by rank and path compression");
        printSet(set2);
    }

    private void MAKE_SET(TreeNode x) {
        x.p = x;
        x.rank = 0;
    }

    private TreeNode FIND_SET(TreeNode x) {
        if (x != x.p) {
            x.p = FIND_SET(x.p);
        }
        return x.p;
    }

    private void UNION(TreeNode x, TreeNode y) {
        LINK(x, y);
    }

    private void LINK(TreeNode x, TreeNode y) {
        if (x.rank > y.rank) {
            y.p = x;
        } else {
            x.p = y;
            if (x.rank == y.rank) {
                y.rank++;
            }
        }
    }

    private void printSet(List<TreeNode> set1) {
        for (TreeNode t : set1) {
            System.out.println("TreeNode is: " + t.c + ", its parent is: " + t.p.c);
        }
    }
}
