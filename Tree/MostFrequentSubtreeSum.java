package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> map;

    public int[] findFrequentTreeSum(TreeNode root) {
        int[] result = new int[0];
        if (root == null) {
            return result;
        }
        map = new HashMap<>();
        help(root);
        int max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                res.add(key);
            }
        }
        int[] result1 = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result1[i] = res.get(i);
        }
        return result1;
    }

    private int help(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            if (map.containsKey(node.val)) {
                int count = map.get(node.val);
                count++;
                map.put(node.val, count);
            } else {
                map.put(node.val, 1);
            }
            return node.val;
        }
        int left = help(node.left);
        int right = help(node.right);
        int sum = left + right + node.val;
        if (map.containsKey(sum)) {
            int count = map.get(sum);
            count++;
            map.put(sum, count);
        } else {
            map.put(sum, 1);
        }
        return sum;
    }
}
