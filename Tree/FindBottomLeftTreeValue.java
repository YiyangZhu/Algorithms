package Tree;

import java.util.LinkedList;

public class FindBottomLeftTreeValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            TreeNode firstNode = q.peek();
            while (!q.isEmpty()) {
                TreeNode n = q.remove();
                if (n.left != null) {
                    nextLevel.add(n.left);
                }
                if (n.right != null) {
                    nextLevel.add(n.right);
                }
            }
            if (nextLevel.size() == 0) {
                return firstNode.val;
            } else {
                q = nextLevel;
            }
        }
        return root.val;
    }
}