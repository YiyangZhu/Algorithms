public class Pattern132BF {
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
        for(int i = 0; i < nums.length - 2;i++){
            for(int j = i+1; j < nums.length - 1;j++){
                if(nums[i] < nums[j]){
                    for(int k = j + 1; k < nums.length;k++){
                        if(nums[k] > nums[i] && nums[k] < nums[j]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}


