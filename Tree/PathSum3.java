package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSum3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> leaf;
    List<List<Integer>> result;
    Map<TreeNode, TreeNode> map;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        leaf = new ArrayList<>();
        map = new HashMap<>();
        map.put(root, null);
        buildMap(root);
        for (TreeNode t : leaf) {
            List<Integer> current = new ArrayList<>();
            if (isValid(t, current, sum)) {
                Collections.reverse(current);
                result.add(current);
            }
        }
        return result;
    }

    private void buildMap(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaf.add(node);
        }
        if (node.left != null) {
            map.put(node.left, node);
            buildMap(node.left);
        }
        if (node.right != null) {
            map.put(node.right, node);
            buildMap(node.right);
        }
    }

    private boolean isValid(TreeNode t, List<Integer> current, int sum) {
        if (t == null) {
            if (sum == 0) {
                return true;
            } else {
                return false;
            }
        }
        current.add(t.val);
        sum -= t.val;
        return isValid(map.get(t), current, sum);
    }

    List<List<Integer>> result1;
    public List<List<Integer>> pathSumMethod2(TreeNode root, int sum) {
        result1 = new ArrayList<>();
        if(root == null){
            return result1;
        }
        List<Integer> current = new ArrayList<>();
        preorder(root,current,sum);
        return result1;
    }

    private void preorder(TreeNode t, List<Integer> current, int sum){
        current.add(t.val);
        sum -= t.val;
        if(t.left == null && t.right == null){
            if(sum == 0){
                result1.add(current);
            }
        }
        if(t.left != null){
            List<Integer> copy = new ArrayList<>(current);
            preorder(t.left,copy,sum);
        }
        if(t.right != null){
            preorder(t.right,current,sum);
        }
    }
}
