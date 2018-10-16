public class RemoveDuplicateInSortedArray {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("AB");
        sb.append('C');
        System.out.println(sb.length());
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int i = 0;
        int j = 0;
        for(i = 0; i < nums.length;i++){
            if(nums[i] > nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
}
