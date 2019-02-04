package MS;


public class QuickSort {
    public int[] quickSort(int[] nums){
        quick(nums,0,nums.length-1);
        return nums;
    }

    public void quick(int[] nums,int start, int end){
        if(start >= end){
            return;
        }
        if(end - start == 1){
            if(nums[start]>nums[end]){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            return;
        }
        int pivotIndex = end;
        int pivot = nums[pivotIndex];
        int i = start;
        int j = start;
        for(j = start;j < end;j++){
            if(nums[j] < pivot){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        int temp = nums[i];
        nums[i] = nums[pivotIndex];
        nums[pivotIndex] = temp;
        quick(nums,start ,i-1 );
        quick(nums,i+1 ,end );

    }
}
