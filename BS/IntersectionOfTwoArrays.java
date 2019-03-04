package BS;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        for(int i: nums1){
            for(int j : nums2){
                if(i == j){
                    set.add(i);
                }
            }
        }

        int[] a1 = new int[set.size()];

        int i = 0;
        for(int j: set){
            a1[i] = j;
            i++;
        }

        return a1;
    }
}
