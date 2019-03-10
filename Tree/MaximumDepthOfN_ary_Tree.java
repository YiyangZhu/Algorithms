package Tree;

import java.util.List;
import java.util.PriorityQueue;

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

    PriorityQueue<Integer> queue;

    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        queue = new PriorityQueue<>((a,b)->(b-a));
        help(root,1);
        return queue.peek();
    }

    private void help(Node node, int depth){
        if(node == null){
            return;
        }
        if(node.children.size() == 0){
            queue.add(depth);
        }
        List<Node> children = node.children;
        for(Node n: children){
            help(n,depth+1);
        }
    }
}