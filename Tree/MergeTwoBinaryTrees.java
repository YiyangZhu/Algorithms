package Tree;

public class MergeTwoBinaryTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }

        if(t2 == null){
            return t1;
        }

        TreeNode root = new TreeNode(t1.val + t2.val);
        help(root,t1,t2);
        return root;
    }

    private void help(TreeNode node, TreeNode node1, TreeNode node2){
        if(node == null || node1 == null && node2 == null){
            return;
        }

        if(node1.left == null && node2.left == null && node1.right == null && node2.right == null){
            return;
        }

        if(node1.left == null){
            node.left = node2.left;
        } else if (node2.left == null){
            node.left = node1.left;
        } else {
            node.left = new TreeNode(node1.left.val + node2.left.val);
            help(node.left,node1.left,node2.left);
        }

        if(node1.right == null){
            node.right = node2.right;
        } else if (node2.right == null){
            node.right = node1.right;
        } else {
            node.right = new TreeNode(node1.right.val + node2.right.val);
            help(node.right,node1.right,node2.right);
        }
    }
}
