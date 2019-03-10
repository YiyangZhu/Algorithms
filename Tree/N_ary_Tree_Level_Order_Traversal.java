package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N_ary_Tree_Level_Order_Traversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        LinkedList<Node> nodes = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        nodes.add(root);
        help(nodes, result);
        return result;
    }

    private void help(LinkedList<Node> nodes, List<List<Integer>> result) {
        if (nodes.size() == 0) {
            return;
        }

        List<Integer> currentList = new ArrayList<>();
        LinkedList<Node> currentLevel = new LinkedList<>();

        while (nodes.size() != 0) {
            Node currentNode = nodes.removeFirst();
            currentList.add(currentNode.val);
            List<Node> children = currentNode.children;
            for (Node next : children) {
                currentLevel.add(next);
            }

        }

        result.add(currentList);
        nodes = currentLevel;

        help(nodes, result);

    }
}