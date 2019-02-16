package G;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return result;
        }

        ArrayList<Integer> sorted = new ArrayList<>();
        int n = nums.length;


        for(int i=n - 1; i>=0; i--){

            //sorted is empty case
            if(sorted.isEmpty()){
                sorted.add(nums[i]);
                result.add(0);
            }

            //if current i is bigger than biggest number in sorted array, then there are sorted.size()-1 numbers smaller than
            //current i
            else if(nums[i]>sorted.get(sorted.size()-1)){
                sorted.add(sorted.size(), nums[i]);
                result.add(sorted.size()-1);
            }

            //current is not bigger than biggest number in sorted array
            //l is 0, r is sorted.size()-1
            else{
                int l=0;
                int r=sorted.size()-1;

                while(l<r){

                    //binary search, and find the location for current i
                    int m = l + (r-l)/2;

                    //if nums[i] is bigger than middle number in sorted array, l start from m+1
                    if(nums[i]>sorted.get(m)){
                        l=m+1;
                    }else{

                        //if nums[i] is not bigger than middle number in sorted array, r equals to middle number
                        r=m;
                    }
                }
                //add current number at specific location, which is r
                //add r to result, which is how many numbers on the right smaller than current i

                sorted.add(r, nums[i]);
                result.add(r);
            }
        }

        //reverse result, as result is starting from the right to the left
        Collections.reverse(result);

        //return result
        return result;

    }
}