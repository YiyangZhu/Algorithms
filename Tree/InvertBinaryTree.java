package Tree;

public class InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        help(root);
        return root;
    }

    private void help(TreeNode node){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            return;
        }
        if(node.left != null && node.right != null){
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            help(node.left);
            help(node.right);
            return;
        }
        if(node.left != null){
            node.right = node.left;
            node.left = null;
            help(node.right);
            return;
        }
        if(node.right != null) {
            node.left = node.right;
            node.right = null;
            help(node.left);
            return;
        }
    }
}
