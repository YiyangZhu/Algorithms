package DP;

public class RangeSumQueryImmutable {
    int[] dp;

    public RangeSumQueryImmutable(int[] nums) {
        if(nums == null || nums.length == 0){
            dp = new int[0];
            return;
        }
        int n = nums.length;
        dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + dp[i - 1];
        }

    }

    public int sumRange(int i, int j) {
        if(dp.length == 0){
            return 0;
        }
        if (i == 0) {
            return dp[j];
        } else {
            return dp[j] - dp[i - 1];
        }

    }
}
