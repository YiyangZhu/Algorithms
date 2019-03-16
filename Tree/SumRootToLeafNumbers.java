package Tree;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> list;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        list = new ArrayList<>();
        preorder(root, "");
        int result = 0;
        for (String s : list) {
            result += Integer.parseInt(s);
        }
        return result;
    }

    private void preorder(TreeNode node, String s) {
        if (node == null) {
            return;
        }
        s += String.valueOf(node.val);
        if (node.left == null && node.right == null) {
            list.add(s);
            return;
        }
        preorder(node.left, s);
        preorder(node.right, s);
    }
}
