package Tree;

import java.util.LinkedList;

public class IncreasingOrderSearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    LinkedList<TreeNode> queue;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        queue = new LinkedList<>();
        inorder(root);
        root = queue.removeFirst();
        TreeNode node = root;
        node.left = null;

        while (!queue.isEmpty()) {
            System.out.println(queue);
            node.right = queue.removeFirst();
            node.left = null;
            node = node.right;
        }
        return root;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        queue.add(node);
        inorder(node.right);
    }

    public static void main(String[] args){
        IncreasingOrderSearchTree i = new IncreasingOrderSearchTree();
        i.Demo();

    }

    public void Demo(){
        TreeNode root = new TreeNode(379);
        root.right = new TreeNode(826);
        increasingBST(root);
    }

}
