package Tree;

import java.util.HashSet;

public class SecondMinimumNodeInABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    HashSet<Integer> set;
    public int findSecondMinimumValue(TreeNode root) {
        set = new HashSet<>();
        if(root == null){
            return -1;
        }
        if(root.left == null && root.right == null){
            return -1;
        }

        constructSet(root);

        int min = Integer.MAX_VALUE;
        for(int i: set){
            if(i < min){
                min = i;
            }
        }
        set.remove(min);
        if(set.size() == 0){
            return -1;
        }
        int secMin = Integer.MAX_VALUE;
        for(int i: set){
            if(i < secMin){
                secMin = i;
            }
        }
        return min != secMin ? secMin : -1;
    }

    private void constructSet(TreeNode node){
        if(node == null){
            return;
        }
        set.add(node.val);
        constructSet(node.left);
        constructSet(node.right);
    }
}
