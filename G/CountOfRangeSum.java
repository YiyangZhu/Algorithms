package G;

public class CountOfRangeSum {
    public static int countRangeSumNaive(int[] nums, int lower, int upper) {
        int n = nums.length;

        int result = 0;

        for (int i = 0; i < n; i++) {
            long sum = (long)nums[i];
            if (sum >= lower && sum <= upper) {
                result++;
            }
            for (int j = i + 1; j < n; j++) {
                sum += (long)nums[j];
                if (sum >= lower && sum <= upper) {
                    result++;
                }
            }
        }

        return result;
    }
}
