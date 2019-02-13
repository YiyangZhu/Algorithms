package G;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        if(nums == null){
            return null;
        }


        List<String> list = new ArrayList<>();
        if( nums.length == 0){
            return list;
        }

        if(nums.length == 1){
            list.add(String.valueOf(nums[0]));
            return list;
        }

        if(nums.length == 2){
            String s1 = String.valueOf(nums[0]);
            String s2 = String.valueOf(nums[1]);
            if((nums[1] - nums[0]) == 1){
                list.add(s1+"->"+s2);
            } else {
                list.add(s1);
                list.add(s2);
            }
            return list;
        }

        int n = nums.length;

        int j = 0;

        if(nums[1] - nums[0] > 1){
            list.add(String.valueOf(nums[0]));
            j = 1;
        }


        for(int i = 1; i < n - 1; i++){
            if((nums[i] - nums[i-1]) == 1 && (nums[i + 1] - nums[i]) == 1){
                continue;
            } else {
                if(nums[i] - nums[i-1] != 1 && nums[i + 1] - nums[i] != 1){
                    list.add(String.valueOf(nums[j]));
                    j = i + 1;
                } else if(nums[i + 1] - nums[i] != 1){
                    String s1 = String.valueOf(nums[j]);
                    String s2 = String.valueOf(nums[i]);
                    list.add(s1+"->"+s2);
                    j = i + 1;
                }
            }
        }

        if(nums[n-1] - nums[n-2] != 1){
            list.add(String.valueOf(nums[n-1]));
        } else {
            String s1 = String.valueOf(nums[j]);
            String s2 = String.valueOf(nums[n-1]);
            list.add(s1+"->"+s2);
        }

        return list;

    }
}
