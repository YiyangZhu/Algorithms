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
            LinkedList<TreeNode> next2 = new LinkedList<>();
            TreeNode n = root;
            while (!q.isEmpty()) {
                n = q.remove();
                if (n.left != null) {
                    nextLevel.add(n.left);
                    if (n.left.left != null) {
                        next2.add(n.left.left);
                    }
                    if (n.left.right != null) {
                        next2.add(n.left.right);
                    }
                }
                if (n.right != null) {
                    nextLevel.add(n.right);
                    if (n.right.left != null) {
                        next2.add(n.right.left);
                    }
                    if (n.right.right != null) {
                        next2.add(n.right.left);
                    }
                }
            }
            if (nextLevel.size() == 0) {
                return n.val;
            }
            if (next2.size() == 0) {
                return nextLevel.peekFirst().val;
            }
            q = nextLevel;
        }
        return root.val;
    }
}
