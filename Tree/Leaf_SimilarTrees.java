package Tree;

import java.util.LinkedList;

public class Leaf_SimilarTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        LinkedList<Integer> queue1 = new LinkedList<>();
        LinkedList<Integer> queue2 = new LinkedList<>();
        constructQueue(root1, queue1);
        constructQueue(root2, queue2);

        while(!queue1.isEmpty() && !queue2.isEmpty()){
            int val1 = queue1.removeFirst();
            int val2 = queue2.removeFirst();
            if(val1 != val2){
                return false;
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }

    private void constructQueue(TreeNode node,LinkedList queue){
        if(node == null){
            return;
        }
        constructQueue(node.left,queue);
        if(node.left == null && node.right == null){
            queue.add(node.val);
        }
        constructQueue(node.right,queue);
    }
}