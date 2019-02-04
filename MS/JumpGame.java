package MS;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxSub = 1;
        int n = nums.length;
        for(int i = 0; i < n;i++){
            maxSub = Math.max(maxSub-1,nums[i]);
            if(maxSub >= (n-1-i)){
                return true;
            } else if(maxSub == 0){
                return false;
            }
        }
        return true;

    }
}