package BS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> map;
    int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        map = new HashMap<>();
        inorder(root);
        List<Integer> list = new LinkedList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int[] array1 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array1[i] = list.get(i);
        }
        return array1;
    }

    public void inorder(TreeNode node) {
        if (node.left != null) {
            inorder(node.left);
        }

        int count = 0;
        if (map.containsKey(node.val)) {
            count = map.get(node.val);
            count++;
            map.put(node.val, count);
        } else {
            map.put(node.val, 1);
        }
        max = Math.max(max, map.get(node.val));

        if (node.right != null) {
            inorder((node.right));
        }
    }
}


