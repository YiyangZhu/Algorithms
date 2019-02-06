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

    public static int trapQuicker(int[] height) {
        if(height == null || height.length < 1){
            return 0;
        }

        int n = height.length;

        int[] leftMax = new int[n];
        leftMax[0] = 0;
        int lMax = leftMax[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(lMax, height[i-1]);
            lMax = leftMax[i];
        }

        int[] rightMax = new int[n];
        rightMax[n-1] = 0;
        int rMax = 0;
        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rMax, height[i + 1]);
            rMax = rightMax[i];
        }


        int sum = 0;
        for (int i = 0; i < height.length;i++){
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            int waterAmount = waterLevel - height[i];
            if(waterAmount <= 0){
                continue;
            } else {
                sum += waterAmount;
            }
        }
        return sum;

    }
}
