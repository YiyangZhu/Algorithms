public class MergeSort {
    public int[] mergeSort(int[] nums) {
        return merge(nums);
    }


    private int[] merge(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        if (nums.length == 1) {

            return nums;
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                int temp = nums[0];
                nums[0] = nums[1];
                nums[1] = temp;
            }
            return nums;
        }
        int n = nums.length;
        int[] left = new int[n/2];
        for(int i = 0; i < n/2;i++){
            left[i] = nums[i];
        }
        int[] right = new int[n-n/2];
        for(int i = 0; i < n-n/2;i++){
            right[i] = nums[n/2+i];
        }
        left = merge(left);
        right = merge(right);
        int[] result = new int[n];
        int i = left.length-1;
        int j = right.length-1;
        int k = n - 1;
        while(i >= 0 && j >= 0){
            if(left[i] >= right[j]){
                result[k] = left[i];
                i--;
            } else {
                result[k] = right[j];
                j--;
            }
            k--;
        }
        while(i>=0){
            result[k] = left[i];
            i--;
            k--;
        }
        while(j>=0){
            result[k] = right[j];
            j--;
            k--;
        }
        return result;
    }

}
