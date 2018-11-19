public class MergeSort {
    public int[] mergeSort(int[] nums) {
        merge(nums,0,nums.length-1);
        return nums;
    }

    private void merge(int[] nums,int start,int end) {
        if (end - start <= 0) {
            return;
        }
        if (end - start == 1) {
            if (nums[start] > nums[end]) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }

        int n = (end - start) / 2;
        merge(nums,start,start+n);
        merge(nums,start+n+1,end);


        int i = start + n;
        int j = end;
        int[] result = new int[end-start+1];
        int k = result.length - 1;

        while(i >= start && j >= start+n+1){
            if(nums[i] > nums[j]){
                result[k] = nums[i];
                i--;
            } else {
                result[k] = nums[j];
                j--;
            }
            k--;
        }
        while(i>=start){
            result[k] = nums[i];
            i--;
            k--;
        }
        while(j>=start+n+1){
            result[k] = nums[j];
            j--;
            k--;
        }
        for(int m = start; m <= end; m++){
            nums[m] = result[m-start];
        }
    }

}
