package BST;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumDistanceBetweenBSTNodes {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int v){
            val = v;
        }
    }

    ArrayList<Integer> list;

    public int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        constructList(root);
        Integer[] array1 = list.toArray(new Integer[list.size()]);
        Arrays.sort(array1 );

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < array1.length; i++){
            res = Math.min(Math.abs(array1[i]-array1[i+1]),res);
        }
        return res;
    }

    public void constructList(TreeNode node){
        if(node == null){
            return;
        }
        list.add(node.val);
        if(node.left != null){
            constructList(node.left);
        }
        if(node.right != null){
            constructList(node.right);
        }
    }
}
