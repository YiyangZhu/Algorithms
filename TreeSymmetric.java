import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeSymmetric {
    public static class TreeNode<E> {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    public static boolean isSymmetric(TreeNode l, TreeNode r){
        if(l == null && r == null){ //leaf returns true
            return true;
        } else if(l == null || r == null){
            return false; //one is null, the other has value, returns false
        }
        if(l.val != r.val){
            return false; //two have values, but different values, return false
        }
        if(!isSymmetric(l.right, r.left)){
            return false;
        }
        if(!isSymmetric(l.left,r.right)){
            return false;
        }
        return true;
    }
}
