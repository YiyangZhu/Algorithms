package BS;

import java.util.ArrayList;
import java.util.Collections;

public class MinimumAbsoluteDifferenceInBST {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int v){
            val = v;
        }
    }

    ArrayList<Integer> list;
    public int getMinimumDifference(TreeNode root) {
        list = new ArrayList<>();

        addNum(root);
        Collections.sort(list );

        Integer[] array1 = list.toArray(new Integer[list.size()]);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < array1.length - 1; i++){
            min = Math.min(min, Math.abs(array1[i]-array1[i+1]));
        }

        return min;
    }

    public void addNum(TreeNode node){
        if(node == null){
            return;
        }
        list.add(node.val);

        if(node.left != null){
            addNum(node.left);
        }
        if(node.right != null){
           addNum(node.right);
        }

    }
}
