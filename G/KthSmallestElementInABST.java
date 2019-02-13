package G;

import java.util.Stack;

public class KthSmallestElementInABST {
    public int kthSmallest(G.TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        Stack<G.TreeNode> stack = new Stack<>();

        G.TreeNode p = root;

        int result = 0;

        while( p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            } else {
                G.TreeNode t = stack.pop();
                k--;
                if(k == 0){
                    result = t.val;
                    p = p.right;
                }
            }
        }
        return result;
    }
}
