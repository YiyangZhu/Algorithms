package DP;

import java.util.Arrays;

public class FrogJump {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0){
            return false;
        }
        int k = 0;
        return helper(stones, 0, k);
    }

    public boolean helper(int[] stones, int i, int k){
        if(i == stones.length - 1){
            return true;
        }

        for(int j = k - 1; j <= k + 1; j++){
            int next = stones[i] + j;
            int nextNum = Arrays.binarySearch(stones,i+1,stones.length,next );
            if(nextNum > 0){
                if(helper(stones,nextNum , j)){
                    return true;
                }
            }
        }
        return false;
    }
}
