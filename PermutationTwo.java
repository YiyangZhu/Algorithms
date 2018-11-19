import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        permuteUnique(nums,0,set);
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

    public void permuteUnique(int[] nums, int start,HashSet<List<Integer>> set){
        if(start >= nums.length){
            List<Integer> list1 = arrayToList(nums);
            set.add(list1);
        } else {
            for(int j = start; j < nums.length;j++){
                if(j != start && nums[j] == nums[start]){
                    continue;
                }
                swap(nums,start ,j);
                permuteUnique(nums,start + 1, set);
                swap(nums,start ,j );
            }
        }

    }

    public List<Integer> arrayToList(int[] nums){
        List<Integer> list1 = new ArrayList<>();
        for(int i: nums){
            list1.add(i);
        }
        return list1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
