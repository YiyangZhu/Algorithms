public class SearchInsertPosition {
    public static void main(String[] args) {
        int target = 5;
        int[] nums = {1, 3, 5, 6};
        System.out.println("result = " + searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int result = 0;
        if (nums[0] > target) {
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] < target) {
                if (nums[i + 1] >= target) {
                    return i + 1;
                }
            }
        }
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        } else {
            return nums.length;
        }
    }
}
