package LeetCodeContest;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int n = preorder.length;
        TreeNode root = construct(preorder, 0, n - 1);
        return root;
    }

    private TreeNode construct(int[] preorder, int i, int j) {
        int n = preorder.length;
        if (i >= n || j >= n || i > j) {
            return null;
        }
        if (i == j) {
            return new TreeNode(preorder[i]);
        }
        TreeNode root = new TreeNode(preorder[i]);
        int index = j + 1;
        for (int k = i + 1; k <= j; k++) {
            if (preorder[k] > preorder[i]) {
                index = k;
                break;
            }
        }

        root.left = construct(preorder, i + 1, index - 1);
        root.right = construct(preorder, index, j);
        return root;
    }

}