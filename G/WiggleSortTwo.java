package G;

import java.util.Arrays;

public class WiggleSortTwo {

    public static void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }

        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);

        int mid = (n - 1) / 2;
        int k = mid;
        for(int i = 0; i < n; i += 2){
            if(k >= 0){
                nums[i] = temp[k--];
            }
        }

        int m = n - 1;
        for(int i = 1; i < n; i += 2){
            if(m > mid){
                nums[i] = temp[m--];
            }
        }
    }
}