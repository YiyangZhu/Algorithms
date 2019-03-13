package Tree;

import java.util.LinkedList;

public class CBTInserter {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    LinkedList<TreeNode> q;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        q = new LinkedList<>();
        this.root = root;
    }

    public int insert(int v) {
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n = q.removeFirst();
            if(n.left != null && n.right != null){
                q.add(n.left);
                q.add(n.right);
            } else {
                if(n.left == null){
                    n.left = new TreeNode(v);
                    q.addFirst(n);
                } else {
                    n.right = new TreeNode(v);
                    q.add(n.left);
                    q.add(n.right);
                }
                return n.val;
            }
        }
        return -1;
    }

    public TreeNode get_root() {
        return root;
    }
}
