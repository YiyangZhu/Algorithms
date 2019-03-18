package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrderDemo {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        PreOrderDemo p = new PreOrderDemo();
        p.demo();
    }

    private void demo() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(preorderDemoIterative(root));

    }

    //recursion way
    List<Integer> result;
    public List<Integer> preorderDemo(TreeNode root) {
        result = new ArrayList<>();
        helper(root);
        return result;
    }

    private void helper(TreeNode t){
        if(t == null){
            return;
        }
        result.add(t.val);
        helper(t.left);
        helper(t.right);
    }

    //iterative way
    public List<Integer> preorderDemoIterative(TreeNode root){
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            if(p != null){
                result.addLast(p.val);
                stack.push(p);
                p = p.left;
            } else {
                TreeNode n = stack.pop();
                p = n.right;
            }
        }
        return result;
    }
}
