package Tree;


import java.util.LinkedList;
import java.util.List;

public class N_aryTreePreorderTraversal {
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

    List<Integer> list;

    public List<Integer> preorder(Node root) {
        list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        help(root);
        return list;
    }

    private void help(Node node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        List<Node> children = node.children;
        for (Node n : children) {
            help(n);
        }
    }
}
