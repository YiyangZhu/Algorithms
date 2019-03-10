package Tree;

import java.util.List;

public class MaximumDepthOfN_ary_Tree {
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

    int i;

    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        i = 0;
        help(root,1);
        return i;
    }

    private void help(Node node, int depth){
        if(node == null){
            return;
        }
        if(node.children.size() == 0){
            if(depth > i){
                i = depth;
            }
        }
        List<Node> children = node.children;
        for(Node n: children){
            help(n,depth+1);
        }
    }
}