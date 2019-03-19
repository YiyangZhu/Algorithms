package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderDemo {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        InOrderDemo i = new InOrderDemo();
        i.demo();
    }

    private void demo() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(inorderDemoIterative(root));
        TreeNode root2 = new TreeNode(0);
        System.out.println(inorderDemoIterative(root2));

    }

    //recursive way
    List<Integer> result;

    public List<Integer> preorderDemo(TreeNode root) {
        result = new ArrayList<>();
        helper(root);
        return result;
    }

    private void helper(TreeNode t) {
        if (t == null) {
            return;
        }
        helper(t.left);
        result.add(t.val);
        helper(t.right);
    }

    //iterative way
    public List<Integer> inorderDemoIterative(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode n = stack.pop();
                result.add(n.val);
                p = n.right;
            }
        }
        return result;
    }
}
