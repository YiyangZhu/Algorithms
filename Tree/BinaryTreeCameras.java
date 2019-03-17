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
//0: no camera, no cover;
//1: no camera, covered;
//2: has camera, covered;

    int result = 0;

    public int minCameraCover(TreeNode root) {
        int rootState = helper(root);

        return rootState == 0 ? result + 1 : result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        //-1
        if (l == -1 && r == -1) {
            return 0;
        }
        if (l == -1 && r == 0) {
            result++;
            return 2;
        }
        if (l == -1 && r == 1) {
            return 0;
        }
        if (l == -1 && r == 2) {
            return 1;
        }
        //0
        if (l == 0 && r == -1) {
            result++;
            return 2;
        }
        if (l == 0 && r == 0) {
            result++;
            return 2;
        }
        if (l == 0 && r == 1) {
            result++;
            return 2;
        }
        if (l == 0 && r == 2) {
            result++;
            return 2;
        }
        //1
        if (l == 1 && r == -1) {
            return 0;
        }
        if (l == 1 && r == 0) {
            result++;
            return 2;
        }
        if (l == 1 && r == 1) {
            return 0;
        }
        if (l == 1 && r == 2) {
            return 1;
        }
        //2
        if (l == 2 && r == -1) {
            return 1;
        }
        if (l == 2 && r == 0) {
            result++;
            return 2;
        }
        if (l == 2 && r == 1) {
            return 1;
        }
        return 1;
    }
}
