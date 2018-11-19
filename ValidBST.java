import java.util.LinkedList;

public class ValidBST {

    public static class TreeNode<e> {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<Integer>(2);
        root.left = new TreeNode<>(1);
        root.right = new TreeNode<>(3);
        System.out.println(isValidBST(root));
    }

    public static  boolean isValidBST(TreeNode root) {
        LinkedList<Integer> allValues = new LinkedList<>();
        if(root == null){
            return true;
        }
        inorderRecord(root,allValues);
        int i = allValues.remove();
        if(allValues == null){
            return true;
        }

        while(!allValues.isEmpty()){
            int j = allValues.remove();
            System.out.println(i);
            System.out.println(j);
            if(j <= i){
                return false;
            }
            i = j;

        }
        return true;
    }

    public static void inorderRecord(TreeNode root,LinkedList<Integer> allValues){
        if(root == null){
            return;
        }
        inorderRecord(root.left,allValues);
        allValues.add(root.val);
        inorderRecord(root.right,allValues);
    }
}

