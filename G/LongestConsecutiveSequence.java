package G;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        quickSort(nums);
        int result = findTotalMaxLen(nums);
        return result;

    }

    public static void quickSort(int[] nums){
        Helper(nums, 0, nums.length - 1);

    }

    public static void Helper(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        int i = start - 1;
        int j = start - 1;
        int pivotIndex = end;
        int pivot = nums[pivotIndex];
        for(int k = start; k < end; k++){
            if(nums[k] > pivot){
                j++;
            } else {
                swap(nums, i + 1, k);
                i++;
                j++;
            }
        }
        swap(nums,i + 1, pivotIndex);
        pivotIndex = i + 1;

        Helper(nums,start ,pivotIndex - 1 );
        Helper(nums,pivotIndex + 1,end );
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int findTotalMaxLen(int[] nums){
        int totalMax = 1;
        int currentMax = 1;
        for(int i = 1; i < nums.length; i++){
            if((nums[i] - nums[i-1]) == 1){
                currentMax++;
                totalMax = Math.max(currentMax, totalMax);
            } else if(nums[i] != nums[i-1]){
                currentMax = 1;
            }
        }
        return totalMax;
    }

    public static int longestConsecutiveSet(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int maxLen = 1;
        for(int i: nums){
            int left = i-1;
            int right = i+1;
            int count = 1;
            while(set.contains(left)){

                set.remove(left);
                left--;
                count++;
            }
            while(set.contains(right)){
                set.remove(right);
                right++;
                count++;
            }
            maxLen = Math.max(maxLen,count );
        }
        return maxLen;

    }
}