package MS;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] array1 = {10,9,2,5,3,7,101,18};
        StringBuilder sb1 = new StringBuilder();
        sb1.append(" "+"the"+" ");
        sb1.append("sky"+" ");
        sb1.append("is"+" ");
        sb1.append("blue."+" ");
        System.out.println(sb1.toString().trim());
    }

    public static  int lengthOfLIS(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int result = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length;i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
                if(dp[i] > result){
                    result = dp[i];
                }
            } else {
                dp[i] = 1;
            }

        }
        return result;

    }
}
