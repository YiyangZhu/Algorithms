package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class FindDuplicateSubtree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> result;
    Set<TreeNode> set;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        set = new HashSet<>();
        preorder(root);
        return result;
    }

    private void preorder(TreeNode t) {
        if (t == null) {
            return;
        }
        for (TreeNode t2 : set) {
            if (isDuplicate(t, t2)) {
                result.add(t);
                set.remove(t2);
                break;
            }
        }

        boolean toPut = true;
        for (TreeNode t2 : result) {
            if (isDuplicate(t, t2)) {
                toPut = false;
                break;
            }
        }
        if (toPut) {
            set.add(t);
        }
        preorder(t.left);
        preorder(t.right);

    }

    private boolean isDuplicate(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null && t2 != null || t1 != null && t2 == null || t1.val != t2.val) {
            return false;
        }
        return isDuplicate(t1.left, t2.left) && isDuplicate(t1.right, t2.right);
    }
}
