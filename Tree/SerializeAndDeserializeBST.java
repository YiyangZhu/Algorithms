package Tree;

import java.util.LinkedList;

public class SerializeAndDeserializeBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        String res = "";
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            LinkedList<TreeNode> next = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode n = q.remove();
                if (n == null) {
                    res += "null" + " ";
                } else {
                    res += n.val + " ";
                    next.add(n.left);
                    next.add(n.right);
                }
            }
            boolean stop = true;
            for (TreeNode n : next) {
                if (n != null) {
                    stop = false;
                }
            }
            if (stop) {
                break;
            }
            q = next;
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] array = data.split(" ");
        if (array[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 1;
        while (index < array.length) {
            LinkedList<TreeNode> next = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode n = q.remove();
                if (index >= array.length) {
                    break;
                }
                String left = array[index];
                if (left.equals("null")) {
                    n.left = null;
                } else {
                    n.left = new TreeNode(Integer.parseInt(left));
                    next.add(n.left);
                }
                index++;
                if (index >= array.length) {
                    break;
                }
                String right = array[index];
                if (right.equals("null")) {
                    n.right = null;
                } else {
                    n.right = new TreeNode(Integer.parseInt(right));
                    next.add(n.right);
                }
                index++;
                if (index >= array.length) {
                    break;
                }
            }

            q = next;
        }
        return root;
    }
}