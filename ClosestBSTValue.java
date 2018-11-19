
public class ClosestBSTValue {
    static int goal;
    static double min = Double.MAX_VALUE;

    public static void main(String[] args) {
    }

    public static int closestValue(TreeNode root, double target) {
        helper(root,target);
        return goal;
    }

    public static void helper(TreeNode root, double target){
        if(root == null){
            return;
        }
        if(Math.abs(target - root.val) < min){
            min = Math.abs(target - root.val);
            goal = root.val;
        }
        if(target < root.val){
            helper(root.left,target );
        } else {
            helper(root.right,target );
        }
    }
}
