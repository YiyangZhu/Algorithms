import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
       int[] array = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(array));
    }

    public static boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            if(set.contains(i)){
                return true;
            } else {
                set.add(i);
            }
        }
        return false;

    }
}
