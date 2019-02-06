package G;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 1){
            return;
        }
        int p = -1;
        int q = -1;
        int n = nums.length;
        //1. R to L, find first number less than previous one,index is p
        for(int k = n - 2; k >= 0; k--){
            if(nums[k] < nums[k + 1]){
                p = k;
                break;
            }
        }

        // if p == -1, reverse nums
        if(p == -1){
            int middle = n / 2;
            for(int k = 0; k <= middle; k++ ){
                swap(nums, k, n-1-k);
            }

            return;
        }

        //2. R to L, find first number greater than index p value, index is q
        for(int k = n - 1; k >= 0; k--){
            if(nums[k] > nums[p]){
                q = k;
                break;
            }
        }

        //3. swap p and q
        swap(nums,p,q);

        //4. reverse p+1 to nums.length - 1
        int middle = p + 1 + (n - p - 2) / 2;
        for(int k = p + 1; k <= middle; k++){
            swap(nums,k,n-k+p);
        }


    }

    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
