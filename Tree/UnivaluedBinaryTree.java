package Tree;

import java.util.HashSet;

public class UnivaluedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashSet<Integer> set;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        set = new HashSet<>();
        traverse(root);

        return set.size() == 1;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        set.add(node.val);
        traverse(node.right);
    }
}
