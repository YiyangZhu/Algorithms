package DP;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        int n = nums.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i == j){
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = dp[i][j-1] * nums[j];
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
