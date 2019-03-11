package Tree;

public class BinaryTreeTilt {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int result;

    public int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        }
        result = 0;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        result += getTilt(node);
        inorder(node.right);
    }

    private int getTilt(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = sum(node.left);
        int right = sum(node.right);
        return Math.abs(left - right );
    }

    private int sum(TreeNode node){
        if(node == null){
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }
}