package MS;


public class MoveZeroes {
    public static void main(String[] args) {

    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
                continue;
            }
            while (i < nums.length && nums[i] == 0) {
                i++;
            }
            if (i < nums.length) {
                nums[j] = nums[i];
                j++;
            }
        }
        for(int k = j; k < nums.length;k++){
            nums[k] = 0;
        }

    }

    public static void displayArray(int[] nums){
        for(int i: nums){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
