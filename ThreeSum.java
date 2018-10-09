import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args){
        int[] S = {-1 ,0, 1, 2, -1, -4};
        displayList(threeSum(S));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2;i++){
            if(i == 0 || nums[i] > nums[i-1]){
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);
                        j++;
                        k--;
                        while(j < k && nums[j]==nums[j-1]){
                            j++;
                        }
                        while(j <k && nums[k] == nums[k+1]){
                            k--;
                        }
                    } else if(nums[i] + nums[j] + nums[k] == 0){
                        j++;
                    } else {
                        k--;
                    }

                }
            }

        }
        return result;
    }

    public static void displayList(List<List<Integer>> result){
        for(List<Integer> list: result){
            for(Integer i: list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
