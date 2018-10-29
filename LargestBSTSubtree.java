
/*
Given a binary tree, find the largest subtree which is a
Binary Search Tree (BST), where largest means subtree with
largest number of nodes in it.
 */
public class LargestBSTSubtree {
    class Wrapper {
        int size;
        int lower, upper;
        boolean isBST;

        public Wrapper() {
            lower = Integer.MAX_VALUE;
            upper = Integer.MIN_VALUE;
            isBST = false;
            size = 0;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        return helper(root).size;
    }

    public Wrapper helper(TreeNode node){
        Wrapper curr = new Wrapper();
        if(node == null && curr.isBST){
            return curr;
        }
        Wrapper l = helper(node.left);
        Wrapper r = helper(node.right);

        curr.lower = Math.min(node.val,l.lower);
        curr.upper = Math.min(node.val,r.upper);

        if(l.isBST && r.isBST && l.upper <= node.val && r.lower >= node.val){
            curr.size = l.size + r.size + 1;
            curr.isBST = true;
        } else {
            curr.size = Math.max(l.size, r.size);
            curr.isBST = false;
        }
        return curr;
    }
}
