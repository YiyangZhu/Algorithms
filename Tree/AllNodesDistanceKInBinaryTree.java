package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list;
    Map<TreeNode, TreeNode> map;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null || target == null) {
            return null;
        }
        list = new ArrayList<>();
        map = new HashMap<>();
        findTarget(root, target);
        buildDown(target, K);
        if (K == 0) {
            return list;
        }
        buildUp(target, K);
        return list;
    }

    private void findTarget(TreeNode node, TreeNode target) {
        if (node == null) {
            return;
        }
        if (node == target) {
            return;
        }
        if (node.left != null) {
            map.put(node.left, node);
        }
        if (node.right != null) {
            map.put(node.right, node);
        }
        findTarget(node.left, target);
        findTarget(node.right, target);
    }

    private void buildDown(TreeNode node, int K) {
        if (node == null) {
            return;
        }
        if (K == 0) {
            list.add(node.val);
            return;
        }
        K--;
        buildDown(node.left, K);
        buildDown(node.right, K);
    }

    private void buildUp(TreeNode node, int K) {
        if (node == null) {
            return;
        }
        if (K == 0) {
            list.add(node.val);
            return;
        }
        K--;
        TreeNode parent = map.get(node);

        buildUp(parent, K);
        if (parent != null) {
            K--;
            if (parent.left != null && parent.left == node) {
                buildDown(parent.right, K);
            } else if (parent.right != null && parent.right == node) {
                buildDown(parent.left, K);
            }
        }
    }
}