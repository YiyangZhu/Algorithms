package G;

public class Patching_Array {
    public static int minPatches(int[] nums, int n) {
        long miss = 1;
        int len = nums.length;
        int count = 0;
        int i = 0;

        while(miss <= n){
            if(i < len && nums[i] <= miss){
                miss += nums[i];
                i++;
            } else {
                count++;
                miss *= 2;
            }
        }

        return count;
    }
}