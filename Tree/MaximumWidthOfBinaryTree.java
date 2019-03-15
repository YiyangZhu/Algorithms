package Tree;

import java.util.LinkedList;

public class MaximumWidthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int max = 0;
        while (!list.isEmpty()) {
            if (list.size() > max) {
                max = list.size();
            }
            LinkedList<TreeNode> currentList = new LinkedList<>();
            for (TreeNode t : list) {
                if (t != null) {
                    currentList.add(t.left);
                    currentList.add(t.right);
                } else {
                    currentList.add(null);
                    currentList.add(null);
                }
            }
            list = currentList;
            while (list.size() != 0 && list.peekFirst() == null) {
                list.removeFirst();
            }
            while (list.size() != 0 && list.peekLast() == null) {
                list.removeLast();
            }
        }
        return max;
    }
}
