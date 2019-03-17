package Tree;

public class BinaryTreeCameras {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //-1: null;
    // 0: no camera, no cover;
    // 1: no camera, covered;
    // 2: has camera, covered;
    int result;

    public int minCameraCover(TreeNode root) {
        result = 0;
        int rootState = helper(root);
        return rootState <= 0 ? result + 1 : result;
    }

    private int helper(TreeNode t) {
        if (t == null) {
            return -1;
        }
        int l = helper(t.left);
        int r = helper(t.right);
        if (l == -1 && r == -1 || l == -1 && r == 1 || l == 1 && r == -1 || l == 1 && r == 1) {
            return 0;
        }
        if (l == 0 || r == 0) {
            result++;
            return 2;
        }
        return 1;
    }
}