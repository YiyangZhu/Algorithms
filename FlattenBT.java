import java.util.LinkedList;

public class FlattenBT {
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


        flatten(root);

    }
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList list1 = new LinkedList();
        flatten(root, list1);
    }

    public static void flatten(TreeNode root, LinkedList list1) {
        if (root == null) {
            list1.add(null);
            return;
        }
        list1.add(root.val);
        System.out.println(list1);
        flatten(root.left, list1);
        flatten(root.right, list1);
    }
}