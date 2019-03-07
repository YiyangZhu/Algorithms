package Tree;

public class ConvertBSTtoGreaterTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int sum;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        sum = 0;
        help(root);
        return root;
    }

    private void help(TreeNode node){
        if(node == null){
            return;
        }
        help(node.right);
        node.val += sum;
        sum = node.val;
        help(node.left);
    }
}
