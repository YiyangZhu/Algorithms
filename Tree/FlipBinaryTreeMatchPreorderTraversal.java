package Tree;

import java.util.ArrayList;
import java.util.List;

public class FlipBinaryTreeMatchPreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int index = 0;
    List<Integer> flipped;
    int[] voyage;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        flipped = new ArrayList<>();
        this.voyage = voyage;
        if(root == null || voyage == null || voyage.length == 0){
            return flipped;
        }
        dfs(root);
        if(flipped.size() > 0 && flipped.get(0) == -1){
            flipped.clear();
            flipped.add(-1);
        }
        return flipped;
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        if(node.val != voyage[index++]){
            flipped.clear();
            flipped.add(-1);
            return;
        }
        if(index < voyage.length && node.left != null && node.left.val != voyage[index]){
            flipped.add(node.val);
            dfs(node.right);
            dfs(node.left);
        } else {
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args){
        FlipBinaryTreeMatchPreorderTraversal f = new FlipBinaryTreeMatchPreorderTraversal();
        f.demo();
    }

    public void demo(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] voyage = {1,3,2,6,7,5,4};
        flipMatchVoyage(root, voyage);
    }

}
