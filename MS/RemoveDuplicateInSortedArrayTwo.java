package MS;

public class RemoveDuplicateInSortedArrayTwo {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));

    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int i = 0;
        int j = 0;
        for(int k = 0; k < nums.length;k++){
            if(nums[k] > nums[j]){
                j++;
                nums[j] = nums[k];
                i = j;
            } else if(nums[k] == nums[j]){
                if(k==j){
                    continue;
                } else if(j == i){
                    j++;
                    nums[j] = nums[k];
                }
            }
            displayArray(nums);
        }
        return j+1;
    }

    public static void displayArray(int[] nums){
        for(int i: nums){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
