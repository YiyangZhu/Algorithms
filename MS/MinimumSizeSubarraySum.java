package MS;


public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println("result = " + minSubArrayLen(s,nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int sum = 0;
        int result = nums.length;
        int start = 0;
        int i = 0;
        boolean exists = false;
        while(i <= nums.length){
            if(sum >= s){
                exists = true;
                if(start == i - 1){
                    return 1;
                }
                result = Math.min(result,i-start);
                sum -= nums[start];
                start++;
            } else {
                if(i == nums.length){
                    break;
                }
                sum += nums[i];
                i++;
            }
        }
        if(exists){
            return result;
        } else {
            return 0;
        }

    }
}
