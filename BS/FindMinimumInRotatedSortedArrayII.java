package BS;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for(int i: nums){
            min = Math.min(min,i);
        }
        return min;
    }
}