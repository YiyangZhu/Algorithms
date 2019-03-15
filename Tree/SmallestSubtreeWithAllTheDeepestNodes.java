package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SmallestSubtreeWithAllTheDeepestNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<TreeNode, TreeNode> parentMap;
    Map<Integer, List<TreeNode>> depthMap;
    Map<TreeNode, Integer> nodeDepthMap;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        parentMap = new HashMap<>();
        depthMap = new HashMap<>();
        nodeDepthMap = new HashMap<>();

        buildParentMap(root, null);
        buildDepthMap(root, 0);
        buildNodeDepthMap(root, 0);


        int max = Integer.MIN_VALUE;
        for (int i : depthMap.keySet()) {

            if (i > max) {
                max = i;
            }
        }

        List<TreeNode> list = depthMap.get(max);
        if (list.size() == 1) {
            return list.get(0);
        }

        TreeNode parent = parentMap.get(list.get(0));

        if (parent == null) {
            return root;
        }
        int parentDepth = nodeDepthMap.get(parent);

        for (TreeNode node : list) {
            TreeNode parent2 = parentMap.get(node);

            if (parent2 == null) {
                return root;
            }
            int parentDepth2 = nodeDepthMap.get(parent2);
            while (parent != parent2) {

                if (parentDepth == parentDepth2) {

                    parent = parentMap.get(parent);
                    parent2 = parentMap.get(parent2);
                    if (parent == null || parent2 == null) {
                        return root;
                    }
                    parentDepth = nodeDepthMap.get(parent);
                    parentDepth2 = nodeDepthMap.get(parent2);
                } else if (parentDepth > parentDepth2) {
                    parent = parentMap.get(parent);
                    if (parent2 == null) {
                        return root;
                    }
                    parentDepth = nodeDepthMap.get(parent);

                } else {
                    parent2 = parentMap.get(parent2);
                    if (parent2 == null) {
                        return root;
                    }
                    parentDepth2 = nodeDepthMap.get(parent2);
                }
            }
        }
        if (parent == null) {
            return root;
        } else {
            return parent;
        }
    }

    private void buildParentMap(TreeNode node, TreeNode parentNode) {
        if (node == null) {
            return;
        }
        parentMap.put(node, parentNode);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }

    private void buildDepthMap(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        List<TreeNode> list;
        if (depthMap.containsKey(depth)) {
            list = depthMap.get(depth);
        } else {
            list = new ArrayList<>();
        }
        list.add(node);
        depthMap.put(depth, list);
        buildDepthMap(node.left, depth + 1);
        buildDepthMap(node.right, depth + 1);
    }

    private void buildNodeDepthMap(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        nodeDepthMap.put(node, depth);
        buildNodeDepthMap(node.left, depth + 1);
        buildNodeDepthMap(node.right, depth + 1);

    }

}