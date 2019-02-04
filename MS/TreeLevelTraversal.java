package MS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeLevelTraversal {
    public static class TreeNode<E> {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelTraverse(root));

    }
    public static List<List<Integer>> levelTraverse(TreeNode root){
        List<List<Integer>> totalValues = new ArrayList<List<Integer>>();
        List<Integer> perLevelValues = new ArrayList<>();
        if(root == null){
            return totalValues;
        }
        LinkedList<TreeNode> currentLevel = new LinkedList<>();
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        currentLevel.add(root);

        while(!currentLevel.isEmpty()){
            TreeNode current = currentLevel.remove();
            if(current.left != null){
                nextLevel.add(current.left);
            }
            if(current.right != null){
                nextLevel.add(current.right);
            }
            perLevelValues.add(current.val);
            if(currentLevel.isEmpty()){
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
                totalValues.add(perLevelValues);
                perLevelValues = new LinkedList<>();
            }
        }
        return totalValues;
    }
}
