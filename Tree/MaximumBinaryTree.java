package Tree;

public class MaximumBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        int[] leftNums = new int[maxIndex];
        int[] rightNums = new int[nums.length - maxIndex - 1];
        for (int i = 0; i < maxIndex; i++) {
            leftNums[i] = nums[i];
        }
        for (int i = maxIndex + 1; i < nums.length; i++) {
            rightNums[i - maxIndex - 1] = nums[i];
        }
        root.left = constructMaximumBinaryTree(leftNums);
        root.right = constructMaximumBinaryTree(rightNums);
        return root;

    }
    public TreeNode constructMaximumBinaryTreeMethod2(int[] nums) {
        return help(nums,0,nums.length-1);
    }

    private TreeNode help(int[] nums, int start, int end){
        if(nums == null || nums.length == 0 || end < start){
            return null;
        }
        if(start == end){
            return new TreeNode(nums[start]);
        }
        int max = nums[start];
        int maxIndex = start;
        for(int i = start + 1; i <= end; i++){
            if(nums[i] > max){
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = help(nums,start,maxIndex-1);
        root.right = help(nums,maxIndex+1,end);
        return root;
    }
}
