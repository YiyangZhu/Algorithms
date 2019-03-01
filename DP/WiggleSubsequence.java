package DP;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 1;

        boolean smaller = true;

        int n = nums.length;
        for (int i = 0; i < n - 1;) {
            if (smaller) {
                if (nums[i] < nums[i + 1]) {
                    smaller = false;
                    result++;
                    while (i < n - 1 &&nums[i] <= nums[i + 1]) {
                        i++;
                    }
                } else {
                    i++;
                }
            } else {
                if (nums[i] > nums[i + 1]) {
                    smaller = true;
                    result++;
                    while (i < n - 1 &&nums[i] >= nums[i + 1]) {
                        i++;
                    }
                } else {
                    i++;
                }
            }
        }

        int result2 = 1;
        smaller = false;
        for (int i = 0; i < n - 1;) {
            if (smaller) {
                if (nums[i] < nums[i + 1]) {
                    smaller = false;
                    result2++;
                    i++;
                    while (i < n - 1 && nums[i] <= nums[i + 1]) {
                        i++;
                    }
                }else {
                    i++;
                }
            } else {
                if (nums[i] > nums[i + 1]) {
                    smaller = true;
                    result2++;
                    i++;
                    while (i < n - 1 &&nums[i] >= nums[i + 1]) {
                        i++;
                    }
                }else {
                    i++;
                }
            }
        }

        return Math.max(result,result2 );

    }
}
