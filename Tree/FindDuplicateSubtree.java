package Tree;

import java.util.*;

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

    Map<String, List<TreeNode>> map;
    public List<TreeNode> findDuplicateSubtreesMethod2(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        map = new HashMap<>();
        postorder(root);
        for(String s: map.keySet()){
            if(map.get(s).size() > 1){
                result.add(map.get(s).get(0));
            }
        }
        return result;
    }
    private String postorder(TreeNode t){
        if(t == null){
            return " ";
        }
        String left = postorder(t.left);
        String right = postorder(t.right);
        String s = left + right + t.val;
        if(map.containsKey(s)){
            List<TreeNode> l = map.get(s);
            l.add(t);
        } else {
            List<TreeNode> l = new ArrayList<>();
            l.add(t);
            map.put(s,l);
        }
        return s;
    }
}
