package Tree;

import java.util.ArrayList;
import java.util.List;

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
}
