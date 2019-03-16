package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode n, List<Integer> res) {
        if (n == null) {
            return;
        }
        res.add(n.val);
        preorder(n.left, res);
        preorder(n.right, res);
    }
}
