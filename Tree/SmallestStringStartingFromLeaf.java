package Tree;

import java.util.PriorityQueue;

public class SmallestStringStartingFromLeaf {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> pq = new PriorityQueue<>();
        help(root,sb,pq);
        return pq.poll();
    }

    private void help(TreeNode root, StringBuilder sb, PriorityQueue<String> pq){
        if(root == null){
            return;
        }
        char c = (char)(root.val + 'a');
        sb.append(c);
        if(root.left == null && root.right == null){
            pq.offer(sb.reverse().toString());
            sb.reverse();
        }
        help(root.left,sb ,pq );
        help(root.right,sb,pq);
        sb.deleteCharAt(sb.length()-1);
    }
}