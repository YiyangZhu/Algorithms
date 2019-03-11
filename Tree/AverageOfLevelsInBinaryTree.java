package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            LinkedList<TreeNode> queue2 = new LinkedList<>();
            double currentSum = 0;
            int num = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.removeFirst();
                currentSum += (double) node.val;
                num++;
                if (node.left != null) {
                    queue2.add(node.left);
                }
                if (node.right != null) {
                    queue2.add(node.right);
                }
            }
            Double d = currentSum / (double) num;
            list.add(d);
            queue = queue2;
        }

        return list;
    }
}
