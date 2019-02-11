package G;

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if(nums == null){
            return -1;
        }

        int n = nums.length;

        if(n == 1){
            return 0;
        }

        int i = 1;
        while(i+1 < n){
            if(nums[i] > nums[i-1] && nums[i] > nums[i + 1]){
                return i;
            }
            i++;
        }

        if(n>=1 && nums[0] > nums[1]){
            return 0;
        }

        if(n-2 >= 0 && nums[n-1] > nums[n-2]){
            return (n-1);
        }
        return -1;
    }
}
