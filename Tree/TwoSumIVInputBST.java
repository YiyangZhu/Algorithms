package Tree;

import java.util.HashSet;

public class TwoSumIVInputBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    HashSet<Integer> set;

    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }

        set = new HashSet<>();

        return help(root,k);
    }

    private boolean help(TreeNode node,int k){
        if(node == null){
            return false;
        }
        if(set.contains(k-node.val)){
            return true;
        }
        set.add(node.val);
        return help(node.left,k) || help(node.right,k);

    }
}