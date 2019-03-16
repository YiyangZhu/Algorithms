package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> current = new LinkedList<>();
            int max = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                if (n.left != null) {
                    current.add(n.left);
                }
                if (n.right != null) {
                    current.add(n.right);
                }
                if (n.val > max) {
                    max = n.val;
                }
            }
            result.add(max);
            queue = current;
        }
        return result;
    }
}
