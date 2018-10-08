import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums,target));

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int index1 = -1;
        int index2 = -1;
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(target-nums[i])){
                index1 = map.get(target-nums[i]);
                index2 = i;
                break;
            }
            map.put(nums[i],i);
        }
        int[] result = {index1,index2};
        System.out.println(index1);
        System.out.println(index2);
        return result;
    }
}
