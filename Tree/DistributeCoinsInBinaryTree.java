package Tree;

public class DistributeCoinsInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int ans;
    public int distributeCoins(TreeNode root) {
        if(root == null){
            return 0;
        }
        ans = 0;
        balance(root);
        return ans;
    }

    private int balance(TreeNode node){
        if(node == null){
            return 0;
        }
        int l = balance(node.left);
        int r = balance(node.right);
        ans += Math.abs(l) + Math.abs(r);
        return l + r + node.val - 1;
    }
}
