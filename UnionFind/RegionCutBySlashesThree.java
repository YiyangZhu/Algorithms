package UnionFind;

import java.util.HashMap;

public class RegionCutBySlashesThree {

    public static void main(String[] args) {
        RegionCutBySlashesThree r = new RegionCutBySlashesThree();
        r.demo();
    }

    public void demo() {
        String[] grid = {" /", "/ "};
        System.out.println(regionsBySlashes(grid));
        String[] grid2 = {" /", "  "};
        System.out.println(regionsBySlashes(grid2));
        String[] grid3 = {"\\/", "/\\"};
        System.out.println(regionsBySlashes(grid3));
        String[] grid4 = {"/\\", "\\/"};
        System.out.println(regionsBySlashes(grid4));
        String[] grid5 = {"//", "/ "};
        System.out.println(regionsBySlashes(grid5));
    }

    public int regionsBySlashes(String[] grid) {
        int result = 1;
        HashMap<Integer, TreeNode> map = new HashMap<>();
        int n = grid.length;
        int index = (n + 1) * (n + 1);

        //make-set
        for (int i = 0; i < index; i++) {
            TreeNode t = new TreeNode(i);
            map.put(i, t);
            MAKE_SET(t);
        }

        //merge outer nodes
        //top
        for (int i = 0; i < n; i++) {
            TreeNode t1 = map.get(i).p;
            TreeNode t2 = map.get(i + 1).p;
            if (t1 != t2) {
                UNION(t1, t2);
            }
        }
        //bottom
        for (int i = n * (n + 1); i < index - 1; i++) {
            TreeNode t1 = map.get(i).p;
            TreeNode t2 = map.get(i + 1).p;
            if (t1 != t2) {
                UNION(t1, t2);
            }
        }
        //left
        for (int j = 0; j < n; j++) {
            TreeNode t1 = map.get(j * (n + 1)).p;
            TreeNode t2 = map.get((j + 1) * (n + 1)).p;
            if (t1 != t2) {
                UNION(t1, t2);
            }
        }
        //right
        for (int j = 0; j < n; j++) {
            TreeNode t1 = map.get(j * (n + 1) + n).p;
            TreeNode t2 = map.get((j + 1) * (n + 1) + n).p;
            if (t1 != t2) {
                UNION(t1, t2);
            }
        }

        for (int i = 0; i < n; i++) {
            String s = grid[i];
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == '/') {
                    int index1 = (i + 1) * (n + 1) + j;
                    int index2 = i * (n + 1) + j + 1;
                    TreeNode t1 = map.get(index1);
                    TreeNode t2 = map.get(index2);
                    TreeNode p1 = FIND_SET(t1);
                    TreeNode p2 = FIND_SET(t2);
                    if (p1 == p2) {
                        result++;
                    } else {
                        UNION(p1, p2);
                    }
                } else if (c == '\\') {
                    int index1 = i * (n + 1) + j;
                    int index2 = (i + 1) * (n + 1) + j + 1;
                    TreeNode t1 = map.get(index1);
                    TreeNode t2 = map.get(index2);
                    TreeNode p1 = FIND_SET(t1);
                    TreeNode p2 = FIND_SET(t2);
                    if (p1 == p2) {
                        result++;
                    } else {
                        UNION(p1, p2);
                    }
                }
            }
        }
        return result;
    }

    private void MAKE_SET(TreeNode t) {
        t.p = t;
        t.rank = 0;
    }

    private TreeNode FIND_SET(TreeNode t) {
        if (t != t.p) {
            t.p = FIND_SET(t.p);
        }
        return t.p;
    }

    private void UNION(TreeNode t1, TreeNode t2) {
        if (t1.rank > t2.rank) {
            t2.p = t1;
        } else {
            t2.p = t1;
            if (t1.rank == t2.rank) {
                t1.rank++;
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode p;
        int rank;

        public TreeNode() {

        }

        public TreeNode(int i) {
            this.val = i;
        }
    }
}
