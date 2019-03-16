package Tree;

public class AddOneRowToTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        help(root, v, d);
        return root;
    }

    private void help(TreeNode n, int v, int d) {
        if (n == null) {
            return;
        }
        if (d == 2) {
            TreeNode l = n.left;
            TreeNode r = n.right;

            if (l != null) {
                TreeNode lNew = new TreeNode(v);
                lNew.left = l;
                n.left = lNew;
            } else {
                n.left = new TreeNode(v);
            }
            if (r != null) {
                TreeNode rNew = new TreeNode(v);
                n.right = rNew;
                rNew.right = r;
            } else {
                n.right = new TreeNode(v);
            }
            return;
        }
        d--;
        help(n.left, v, d);
        help(n.right, v, d);
    }
}
