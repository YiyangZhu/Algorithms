package MS;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int max = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int e: nums){
            set.add(e);
        }
        for(int e: nums){
            int count = 1;
            int left = e - 1;
            int right = e + 1;
            while(set.contains(left)){
                System.out.println("left="+left);
                System.out.println(set);
                count++;
                set.remove(left);
                left--;
            }
            System.out.println(set);
            while(set.contains(right)){
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(count,max);
        }
        return max;

    }
}
