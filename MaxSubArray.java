public class MaxSubArray {
    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(array));
        String s = "";
        System.out.println(s.length());
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i], nums[i] + sum[i - 1]);
            max = Math.max(sum[i], max);
        }
        return max;
    }
}
