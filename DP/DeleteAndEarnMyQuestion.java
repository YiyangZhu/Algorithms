package DP;

public class DeleteAndEarnMyQuestion {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if (n == 3) {
            int left = nums[0] + nums[1];
            int middle = nums[0] + nums[2];
            int right = nums[1] + nums[2];
            return Math.max(left, Math.max(middle, right));
        }

        int row = n / 3;
        int[][] dp = new int[row][3];

        int left = nums[3 * 0] + nums[3 * 0 + 1];
        int middle = nums[3 * 0] + nums[3 * 0 + 2];
        int right = nums[3 * 0 + 1] + nums[3 * 0 + 2];

        int result = 0;

        dp[0] = new int[]{left,middle,right};

        for (int i = 1; i < row; i++) {
            int lastLeft = dp[i-1][0];
            int lastMiddle = dp[i-1][1];
            int lastRight = dp[i-1][2];

            left = nums[3 * i] + nums[3 * i + 1];
            middle = nums[3 * i] + nums[3 * i + 2];
            right = nums[3 * i + 1] + nums[3 * i + 2];

            int one = left + lastLeft;
            int two = middle + lastLeft;
            int three = middle + lastMiddle;
            int four = right + lastLeft;
            int five = right + lastMiddle;
            int six = right + lastRight;

            int first = one;
            int second = Math.max(two,three);
            int third = Math.max(four,Math.max(five,six) );

            dp[i] = new int[]{first,second,third};
        }
        int rest = n - row * 3;
        int[] last = dp[row-1];
        if(rest == 0){
            return Math.max(last[0],Math.max(last[1],last[2]));
        }
        if(rest == 1){
            return Math.max(last[0]+nums[n-1],Math.max(last[1],last[2] ));
        }
        if(rest == 2){
            int first = nums[n-1] + nums[n-2] + last[0];
            int second = nums[n-2] + last[1];
            int third = last[2];
            return Math.max(first, Math.max(second,third));
        }
        return 0;
    }
}
