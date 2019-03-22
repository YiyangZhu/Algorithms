package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedundantConnectionII {
    public static void main(String[] args) {
        RedundantConnectionII r = new RedundantConnectionII();
        r.demo();
    }

    private void demo() {
        int[][] a1 = {{1, 2}, {1, 3}, {2, 3}};
        findRedundantDirectedConnection(a1);
    }

    public class Node {
        Node p;
        int i;

        public Node(int i) {
            this.i = i;
        }
    }

    private void makeSet(Node n) {
        n.p = n;
    }

    private Node findSet(Node n) {
        if (n != n.p) {
            n.p = findSet(n.p);
        }
        return n.p;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        Set<Node> set = new HashSet<>();
        Map<Integer, Node> map = new HashMap<>();
        for (int[] edge : edges) {
            int i1 = edge[0];
            int i2 = edge[1];
            Node n1 = null;
            Node n2 = null;
            if (map.containsKey(i1)) {
                n1 = map.get(i1);
            } else {
                n1 = new Node(i1);
                map.put(i1, n1);
                makeSet(n1);
            }
            if (map.containsKey(i2)) {
                n2 = map.get(i2);
            } else {
                n2 = new Node(i2);
                map.put(i2, n2);
                makeSet(n2);
            }
            Node p1 = findSet(n1);
            Node p2 = findSet(n2);
            if (p1 == n1 && p2 == n2) {
                n2.p = n1;
            } else if (p2 == n2 && p1 != n2) {
                n2.p = n1;
            } else {
                return edge;
            }
        }
        return edges[0];
    }
}