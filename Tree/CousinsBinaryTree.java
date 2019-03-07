package Tree;

import java.util.HashMap;
import java.util.Map;

public class CousinsBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> map1;
    Map<Integer, Integer> map2;

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }

        map1 = new HashMap<>();
        map2 = new HashMap<>();

        help(root,0);

        if(map1.get(x) == map1.get(y) && map2.get(x) != map2.get(y)){
            return true;
        } else{
            return false;
        }

    }

    public void help(TreeNode node,int i){
        if(node == null){
            return;
        }
        map1.put(node.val,i);
        if(node.left != null){
            map2.put(node.left.val,node.val);
        }
        if(node.right != null){
            map2.put(node.right.val,node.val);
        }
        i++;
        help(node.left,i);
        help(node.right,i);
    }
}
