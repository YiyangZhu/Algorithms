package Tree;

import java.util.LinkedList;

public class CountCompleteTreeNode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int i;

    public int countNodes(TreeNode root) {
        i = 0;
        if (root == null) {
            return 0;
        }
        help(root);
        return i;
    }

    private void help(TreeNode node) {
        if (node == null) {
            return;
        }
        if (isComplete(node)) {
            i++;
        }
        help(node.left);
        help(node.right);
    }

    private boolean isComplete(TreeNode node) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            LinkedList<TreeNode> next = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode n = q.remove();
                if (n == null && !q.isEmpty()) {
                    return false;
                }
                if (n == null) {
                    break;
                }
                if (n.left != null) {
                    next.add(n.left);
                }
                if (n.right != null) {
                    next.add(n.right);
                }
            }
            q = next;
        }
        return true;
    }
}
