package Tree;

public class HouseRobberIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        int[] ans = help(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] help(TreeNode t) {
        int[] ans = new int[2];
        if (t == null) {
            ans[0] = 0;
            ans[1] = 0;
            return ans;
        }
        int[] l = help(t.left);
        int[] r = help(t.right);
        ans[0] = t.val + l[1] + r[1];
        ans[1] = Math.max(Math.max(l[0] + r[0], l[1] + r[1]), Math.max(l[0] + r[1], l[1] + r[0]));
        return ans;
    }
}
