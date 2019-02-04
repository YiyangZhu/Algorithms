import java.util.HashMap;

public class TwoSumTwo {
    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums,target));

    }

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < numbers.length;i++){
            if(map.containsKey(target - numbers[i])){
                index1 = map.get(target - numbers[i]) + 1;
                index2 = i + 1;
                break;
            }
            map.put(numbers[i],i);
        }
        int[] result = {index1,index2};
        System.out.println(index1);
        System.out.println(index2);
        return result;

    }
}
