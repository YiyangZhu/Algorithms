package Tree;

import java.util.LinkedList;

public class CheckCompletenessOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //use recursion
    public boolean isCompleteTree(TreeNode root) {
        //offer return a boolean value, which is unnecessary in this question
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.peek() != null){
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while(!queue.isEmpty() && queue.peek() == null){
            queue.poll();
        }

        return queue.isEmpty();
    }

    public boolean isCompleteTree2(TreeNode root) {
        //add is better
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.peek() != null){
            TreeNode node = queue.remove();
            queue.add(node.left);
            queue.add(node.right);
        }
        while (!queue.isEmpty() && queue.peek() == null){
            queue.remove();
        }
        return queue.isEmpty();
    }

    public boolean isCompleteTree3(TreeNode root) {
        //addlast is better
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(queue.peekFirst() != null){
            TreeNode node = queue.removeFirst();
            queue.addLast(node.left);
            queue.addLast(node.right);
        }
        while(!queue.isEmpty() && queue.peekFirst() == null){
            queue.removeFirst();
        }
        return queue.isEmpty();
    }

    public boolean isCompleteTree4(TreeNode root) {
        //offer return a boolean value, which is unnecessary in this question
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (queue.peekFirst() != null){
            TreeNode node = queue.pollFirst();
            queue.offerLast(node.left);
            queue.offerLast(node.right);
        }

        while(!queue.isEmpty() && queue.peekFirst() == null){
            queue.pollFirst();
        }
        return queue.isEmpty();

    }
}
