package DP;

public class UniqueBinarySearchTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            this.val = v;
        }
    }

    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];

    }
}
