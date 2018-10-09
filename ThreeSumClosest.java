import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {0,2,1,-3};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));


    }

    public static int threeSumClosest(int[] nums, int target) {
        int minValue = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if (diff == 0) {
                    return sum;
                }
                if(diff < minValue){
                    result = sum;
                    minValue = diff;
                }
                if(sum < target){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;

    }
}
