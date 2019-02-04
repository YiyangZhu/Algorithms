package MS;

import java.util.ArrayList;
import java.util.List;


public class Permutation {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    public void permute(int[] nums,int start, List<List<Integer>> result){
        if(start >= nums.length){
            List<Integer> list1 = arrayToList(nums);
            result.add(list1);
        } else {
            for(int j = start; j < nums.length;j++){
                swap(nums,start ,j );
                permute(nums,start+1 ,result );
                swap(nums,start,j);
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

    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}