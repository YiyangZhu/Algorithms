package Tree;

public class DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int result;

    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        if(root == null){
            return result;
        }
        help(root);
        return result;
    }

    private int help(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = help(node.left);
        int right = help(node.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }
}
