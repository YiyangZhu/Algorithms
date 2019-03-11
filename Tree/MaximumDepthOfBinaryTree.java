package Tree;

public class MaximumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int i = 0;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        i = 0;
        help(root,1);
        return i;
    }
    private void help(TreeNode node, int val){
        if(node == null){
            if(val - 1 > i){
                i = val - 1;
            }
            return;
        }
        val++;
        help(node.left,val);
        help(node.right,val);
    }
}