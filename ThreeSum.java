import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int k = i + 1;
            int j = nums.length - 1;
            while(k < j){
                if(nums[i] + nums[k] + nums[j] == 0){
                    List<Integer> list1 = new ArrayList<>(asList(nums[i],nums[k],nums[j]));

                    result.add(list1);
                    k++;
                    while(k < j && nums[k] == nums[k-1]){
                        k++;
                    }
                    j--;
                    while(k < j && nums[j] == nums[j + 1]){
                        j--;
                    }

                } else if(nums[i] + nums[k] + nums[j] < 0){
                    k++;
                    while(k < j && nums[k] == nums[k - 1]){
                        k++;
                    }
                } else {
                    j--;
                    while(k < j && nums[j] == nums[j + 1]){
                        j--;
                    }
                }
            }
        }
        return result;
    }
}