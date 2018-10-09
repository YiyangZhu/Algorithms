import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] S = {5,5,3,5,1,-5,1,-2};
        int target = 4;
        displayList(fourSum(S, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for(int x: nums){
            System.out.print(x+" ");
        }
        System.out.println();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] > nums[j - 1]) {
                        int k = j + 1;
                        int m = nums.length - 1;
                        System.out.println("before while: i="+i+"\tj="+j+"\tk="+k+"\tm="+m);

                        while (k < m) {
                            System.out.println("after while: i="+i+"\tj="+j+"\tk="+k+"\tm="+m);
                            if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                                System.out.println("in if");
                                System.out.println();
                                List<Integer> l = new ArrayList<>();
                                l.add(nums[i]);
                                l.add(nums[j]);
                                l.add(nums[k]);
                                l.add(nums[m]);
                                result.add(l);
                                k++;
                                m--;
                                while (k < m && nums[k] == nums[k - 1]) {
                                    k++;
                                }
                                while (k < m && nums[m] == nums[m + 1]) {
                                    m--;
                                }
                            } else if (nums[i] + nums[j] + nums[k] + nums[m] < target) {
                                k++;
                            } else {
                                m--;
                            }

                        }
                    }
                }
            }
        }
        return result;
    }

    public static void displayList(List<List<Integer>> result) {
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
