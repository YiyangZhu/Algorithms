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

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null){
            return null;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Map<Integer, List<TreeNode>> depthMap = new HashMap<>();
        Map<TreeNode, Integer> nodeDepthMap = new HashMap<>();
        buildMap(root,null,0,parentMap,depthMap,nodeDepthMap);
        int max = Integer.MIN_VALUE;
        for(int i: depthMap.keySet()){
            if(i > max){
                max = i;
            }
        }
        List<TreeNode> list = depthMap.get(max);
        if(list.size() == 1){
            return list.get(0);
        }
        TreeNode parent = parentMap.get(list.get(0));
        for(TreeNode node: list){
            TreeNode parent2 = parentMap.get(node);
            while(parent != parent2 && parent != null && parent2 != null){
                int parentDepth = nodeDepthMap.get(parent);
                int parentDepth2 = nodeDepthMap.get(parent2);
                if(parentDepth == parentDepth2){
                    parent = parentMap.get(parent);
                    parent2 = parentMap.get(parent2);
                } else if(parentDepth > parentDepth2){
                    parent = parentMap.get(parent);
                } else {
                    parent2 = parentMap.get(parent2);
                }
            }
        }
        if(parent == null){
            return root;
        } else {
            return parent;
        }
    }

    private void buildMap(TreeNode node, TreeNode parentNode,int depth,Map<TreeNode, TreeNode> parentMap, Map<Integer, List<TreeNode>> depthMap, Map<TreeNode, Integer> nodeDepthMap){
        if(node == null){
            return;
        }
        List<TreeNode> list;
        if(depthMap.containsKey(depth)){
            list = depthMap.get(depth);
        } else {
            list = new ArrayList<>();
        }
        list.add(node);
        depthMap.put(depth,list);
        nodeDepthMap.put(node,depth);
        parentMap.put(node,parentNode);
        buildMap(node.left,node,depth+1,parentMap,depthMap,nodeDepthMap);
        buildMap(node.right,node,depth+1,parentMap,depthMap,nodeDepthMap);
    }
}