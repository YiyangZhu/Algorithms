public class SortColor {
    public static void main(String[] args){
        int[] n = {2,0,2,1,1,0};
        sortColors(n);
        for(int i = 0; i < n.length;i++){
            System.out.print(n[i]+" ");
        }

    }
    public static  void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0){
                count0++;
            } else if(nums[i] == 1){
                count1++;
            }
        }
        System.out.println(count0);
        for(int i = 0; i < count0;i++){
            nums[i] = 0;
        }
        for(int i = count0; i < count0+count1;i++){
            nums[i] = 1;
        }
        for(int i = count0+count1;i < nums.length;i++){
            nums[i] = 2;
        }
    }
}
