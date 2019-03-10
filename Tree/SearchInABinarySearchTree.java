package Tree;

public class SearchInABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode node;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        help(root,val);
        return node;
    }

    private void help(TreeNode root,int val){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        if(root.left != null && root.left.val == val){
            node = root.left;
            root.left = null;
            return;
        }
        if(root.right != null && root.right.val == val){
            node = root.right;
            root.right = null;
            return;
        }
        help(root.left,val);
        help(root.right,val);
    }
}
