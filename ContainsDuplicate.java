import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContainsDuplicate {
    public static void main(String[] args) {
       int[] array = {1,2,3,1};
       int k = 3;
        System.out.println(containsNearbyDuplicate(array,k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 1){
            return false;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(nums[i])){
                ArrayList<Integer> list0 = map.get(nums[i]);
                for(int index: list0){
                    System.out.println("i="+i+"\tindex="+index);
                    if((i - index) <= k){
                        return true;
                    }
                }
                list0.add(i);
                map.put(nums[i], list0);
            } else {
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(i);
                map.put(nums[i], list1);
            }
        }
        return false;

    }
}
