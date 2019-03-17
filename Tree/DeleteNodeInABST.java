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
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right == null) {
                root = root.left;
            } else if (root.left == null) {
                root = root.right;
            } else {
                TreeNode s = findS(root);
                s.left = root.left;
                deleteS(root, s);
                s.right = root.right;
                root = s;
            }
            return root;
        }
        find(root, key);
        if (p == null) {
            return root;
        }

        if (p.left != null && p.left.val == key) {
            TreeNode d = p.left;
            if (d.left == null && d.right == null) {
                p.left = null;
            } else if (d.left == null) {
                p.left = d.right;
            } else if (d.right == null) {
                p.left = d.left;
            } else {
                TreeNode s = findS(d);
                s.left = d.left;
                deleteS(d, s);
                s.right = d.right;
                p.left = s;
            }
        } else {
            TreeNode d = p.right;
            if (d.left == null && d.right == null) {
                p.right = null;
            } else if (d.left == null) {
                p.right = d.right;
            } else if (d.right == null) {
                p.right = d.left;
            } else {
                TreeNode s = findS(d);
                s.left = d.left;
                deleteS(d, s);
                s.right = d.right;
                p.right = s;
            }
        }
        return root;
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
