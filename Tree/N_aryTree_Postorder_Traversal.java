package Tree;

import java.util.LinkedList;
import java.util.List;

public class N_aryTree_Postorder_Traversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<Integer> list;
    public List<Integer> postorder(Node root) {
        if(root == null){
            return list;
        }
        list = new LinkedList<>();
        help(root);
        return list;
    }

    private void help(Node node){
        if(node == null){
            return;
        }

        List<Node> children = node.children;
        for(Node c: children){
            help(c);
        }
        list.add(node.val);
    }
}
