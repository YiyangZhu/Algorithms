package MS;

public class ClosestBinarySearchTreeValue {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            val = value;

        }
    }
    public int closestValue(TreeNode root, double target) {
        int closetValue = root.val;
        double minDiff = Math.abs(closetValue - target);
        while (root != null){
            if(root.val == target){
                return root.val;
            } else if (root.val < target){
                if(Math.abs(root.val -target) < minDiff){
                    closetValue = root.val;
                    minDiff = Math.abs(root.val -target);
                }
                root = root.right;
            } else {
                if(Math.abs(root.val -target) < minDiff){
                    closetValue = root.val;
                    minDiff = Math.abs(root.val -target);
                }
                root = root.left;
            }
        }
        return closetValue;
    }
}
