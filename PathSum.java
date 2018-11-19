public class PathSum {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right = new TreeNode(1);
        int sum = 22;
        System.out.println(bfs(root,sum));
    }

    public static boolean bfs(TreeNode root,int sum){
        if(root.left == null && root.right == null){
            if(root.val == sum){
                return true;
            } else {
                return false;
            }
        }
        if(root.left == null){
            return bfs(root.right,sum-root.val);
        }
        if(root.right == null){
            return bfs(root.left,sum-root.val);
        }
        return bfs(root.left,sum - root.val) || bfs(root.right,sum-root.val);
    }


}
