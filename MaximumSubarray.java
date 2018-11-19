public class MaximumSubarray {
    /*
    [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1]
     */
    public int maxSubArray(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i < nums.length;i++){
            currentSum = Math.max(currentSum + nums[i],nums[i]);
            maxValue = Math.max(maxValue,currentSum);
        }
        return maxValue;
    }
}
