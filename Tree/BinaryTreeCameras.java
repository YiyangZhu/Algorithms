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

    //0: no camera, no cover
    //1: no camera, has cover
    //2: null
    //3: has camera, has cover

    int result;

    public int minCameraCover(TreeNode root) {
        result = 0;
        int rootState = helper(root);
        return rootState == 0 ? result + 1 : result;
    }

    private int helper(TreeNode t) {
        if (t == null) {
            return 2;
        }
        int l = helper(t.left);
        int r = helper(t.right);
        if (l == 0 || r == 0) {
            result++;
            return 3;
        }
        if (l <= 2 && r <= 2) {
            return 0;
        }
        return 1;
    }
}