package Tree;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeMap<int[], Integer> map = new TreeMap<>(new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                if (a1[0] != a2[0]) {
                    return a1[0] - a2[0];
                }
                if (a1[1] != a2[1]) {
                    return a2[1] - a1[1];
                }
                return a1[2] - a2[2];
            }
        });

        help(root, 0, 0, map);

        Map<Integer, List<Integer>> map2 = new HashMap<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int[] key : map.keySet()) {

            List<Integer> list1;
            if (map2.containsKey(key[0])) {
                list1 = map2.get(key[0]);
            } else {
                list1 = new LinkedList<>();
            }
            list1.add(key[2]);

            if (linkedList.isEmpty()) {
                linkedList.add(key[0]);
            } else if (!linkedList.isEmpty() && linkedList.peekLast() != key[0]) {
                linkedList.add(key[0]);
            }

            map2.put(key[0], list1);
        }

        while (!linkedList.isEmpty()) {
            int key = linkedList.removeFirst();
            result.add(map2.get(key));
        }

        return result;
    }

    private void help(TreeNode node, int Y, int X, TreeMap<int[], Integer> map) {
        if (node == null) {
            return;
        }
        int[] array = new int[3];
        array[0] = Y;
        array[1] = X;
        array[2] = node.val;
        map.put(array, node.val);

        help(node.left, Y - 1, X - 1, map);
        help(node.right, Y + 1, X - 1, map);
    }
}
