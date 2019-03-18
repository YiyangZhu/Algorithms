package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> result;

    public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        helper(root);
        return result;
    }

    private void helper(TreeNode t) {
        if (t == null) {
            return;
        }
        helper(t.left);
        helper(t.right);
        result.add(t.val);
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || stack.isEmpty()) {
            if (p != null) {
                result.addFirst(p.val);
                stack.add(p);
                p = p.right;
            } else {
                TreeNode n = stack.pop();
                p = n.left;
            }
        }
        return result;
    }
}
