package MS;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        int[] array = {3,3};
        int[] outcome = twoSum(array, 6);
        System.out.println(outcome[0]+" "+outcome[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Set<Integer> h = new HashSet<>();
        for(int i = 0; i < nums.length;i++){
            if(h.contains(target - nums[i])){
                result[1] = i;
                break;
            }
            h.add(nums[i]);
        }
        for(int i = 0; i < result[1]; i++){
            if (nums[i] == target - nums[result[1]]){
                result[0] = i;
                break;
            }
        }
        return result;
    }
}
