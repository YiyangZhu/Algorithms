public class Pattern132BF2 {
    public static void main(String[] args){
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {3, 1, 4, 2};
        int[] a3 = {-1, 3, 2, 0};
        System.out.println(find132pattern(a1));
        System.out.println(find132pattern(a2));
        System.out.println(find132pattern(a3));
    }

    public static boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }
        for(int i = 0; i < nums.length - 2; i++){
            int maxValue = nums[i+1];
            for(int j = i + 2; j< nums.length;j++){
                if(nums[i] < nums[j] && maxValue > nums[j]){
                    return true;
                } else {
                    if(maxValue < nums[j]){
                        maxValue = nums[j];
                    }
                }
            }
        }
        return false;
    }
}



