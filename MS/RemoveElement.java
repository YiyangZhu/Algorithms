package MS;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));

    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
                continue;
            }
            while (i < nums.length && nums[i] == val) {
                i++;
            }
            if (i < nums.length) {
                nums[j] = nums[i];
                j++;
            }
            displayArray(nums);
        }
        return j;
    }

    public static void displayArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
