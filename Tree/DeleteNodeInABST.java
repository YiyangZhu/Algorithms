package Tree;

public class DeleteNodeInABST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode p;

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode sentinel = new TreeNode(0);
        sentinel.left = root;
        find(sentinel, key);
        if (p == null) {
            return root;
        }
        if (p.left != null && p.left.val == key) {
            TreeNode d = p.left;
            p.left = setD(d);
        } else {
            TreeNode d = p.right;
            p.right = setD(d);
        }
        return sentinel.left;
    }

    private TreeNode setD(TreeNode d) {
        if (d.left == null && d.right == null) {
            return null;
        } else if (d.left == null) {
            return d.right;
        } else if (d.right == null) {
            return d.left;
        } else {
            TreeNode s = findS(d);
            s.left = d.left;
            deleteS(d, s);
            s.right = d.right;
            return s;
        }
    }

    private void find(TreeNode t, int k) {
        if (t == null) {
            return;
        }
        if (t.left != null) {
            if (t.left.val == k) {
                p = t;
                return;
            }
            find(t.left, k);
        }
        if (t.right != null) {
            if (t.right.val == k) {
                p = t;
                return;
            }
            find(t.right, k);
        }
    }

    private TreeNode findS(TreeNode d) {
        d = d.right;
        while (d.left != null) {
            d = d.left;
        }
        return d;
    }

    private void deleteS(TreeNode d, TreeNode s) {
        if (s == d.right) {
            d.right = s.right;
            return;
        }
        d = d.right;
        while (d.left != null && d.left.val != s.val) {
            d = d.left;
        }
        d.left = s.right;
    }
}