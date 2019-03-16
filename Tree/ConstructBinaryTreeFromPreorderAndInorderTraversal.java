package Tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        return help(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode help(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int index = inStart;
        for (index = inStart; index <= inEnd; index++) {
            if (inorder[index] == preorder[preStart]) {
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = help(preorder, inorder, preStart + 1, preStart + index - inStart, inStart, index - 1);
        root.right = help(preorder, inorder, preStart + index - inStart + 1, preEnd, index + 1, inEnd);
        return root;
    }
}
