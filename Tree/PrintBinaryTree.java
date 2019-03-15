package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int height;
    Map<TreeNode, int[]> map;
    String[][] matrix;

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        map = new HashMap<>();
        height = 0;
        getHeight(root, 1);
        int W = getW(root);
        int rootIndex = W / 2;

        matrix = new String[height][W];
        int[] rootP = {0, W / 2};
        map.put(root, rootP);
        fillMatrix(root, 0, 0, W - 1);
        for (String[] s : matrix) {
            List<String> list1 = new ArrayList<>();
            for (String s1 : s) {
                if (s1 == null) {
                    list1.add("");
                } else {
                    list1.add(s1);
                }
            }
            list.add(list1);
        }
        return list;
    }

    private void getHeight(TreeNode node, int val) {
        if (node.left == null && node.right == null) {
            if (val > height) {
                height = val;
            }
            return;
        }
        val++;
        if (node.right != null) {
            getHeight(node.right, val);
        }
        if (node.left != null) {
            getHeight(node.left, val);
        }
    }

    private int getW(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getW(node.left);
        int right = getW(node.right);
        return Math.max(left, right) * 2 + 1;
    }

    private void fillMatrix(TreeNode node, int row, int colStart, int colEnd) {
        if (node == null) {
            return;
        }
        int[] a1 = map.get(node);
        int i = row;
        int j = colStart + (colEnd - colStart) / 2;
        matrix[i][j] = String.valueOf(node.val);
        row++;
        if (node.left != null) {
            fillMatrix(node.left, row, colStart, j - 1);
        }
        if (node.right != null) {
            fillMatrix(node.right, row, j + 1, colEnd);
        }
    }
}
