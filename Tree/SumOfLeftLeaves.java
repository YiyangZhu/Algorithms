package Tree;

import java.util.HashSet;

public class SumOfLeftLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    HashSet<TreeNode> set;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        set = new HashSet<>();
        help(root);
        int result = 0;
        for(TreeNode node: set){
            if(node.left == null && node.right == null){
                result += node.val;
            }
        }
        return result;
    }

    private void help(TreeNode node){
        if(node == null){
            return;
        }
        help(node.left);
        if(node.left != null){
            set.add(node.left);
        }
        help(node.right);
    }
}
