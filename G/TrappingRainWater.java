package G;

public class TrappingRainWater {
    public static int trap(int[] height) {

        int sum = 0;
        for (int i = 0; i < height.length;i++){
            int leftMax = leftMax(height,i );
            int rightMax = rightMax(height, i );
            int waterLevel = Math.min(leftMax,rightMax);
            int waterAmount = waterLevel - height[i];
            if(waterAmount <= 0){
                continue;
            } else {
                sum += waterAmount;
            }
        }
        return sum;

    }

    public static int leftMax(int[] nums, int index){
        int max = nums[index];
        for(int i = index - 1; i >= 0 ;i--){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }

    public static int rightMax(int[] nums, int index){
        int max = nums[index];
        for(int i = index + 1; i < nums.length ;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }


}
