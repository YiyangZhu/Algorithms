package Tree;

public class ConstructStringFromBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String result = "" + t.val;

        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left.equals("") && right.equals("")) {
            return result;
        }
        if (left.equals("")) {
            return result + "()" + "(" + right + ")";
        }
        if (right.equals("")) {
            return result + "(" + left + ")";
        }
        return result + "(" + left + ")" + "(" + right + ")";

    }
}
