import java.util.Arrays;
import java.util.HashSet;

public class Game24 {
    public static void main(String[] args){
        int[] nums = {1,1,1,8};
        System.out.println(judgePoint24(nums));


    }

    public static boolean judgePoint24(int[] nums) {
        HashSet<int[]> totalSet = new HashSet<>();
        int[] array1 = {1,1,8,1};
        Arrays.sort(array1);
        totalSet.add(array1);
        System.out.println(totalSet);

        HashSet<Integer> set2 = new HashSet<>();
        Arrays.sort(nums);
        if(totalSet.contains(nums)){
            return true;
        }
        return false;
    }
}
