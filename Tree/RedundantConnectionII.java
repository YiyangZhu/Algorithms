package Tree;

import java.util.HashMap;
import java.util.Map;

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

        Node(int i) {
            this.i = i;
            p = null;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] twoParent = null;
        boolean hasCycle = false;
        int[] last = null;
        Map<Integer, Node> map = new HashMap<>();
        for (int[] edge : edges) {
            int e1 = edge[0];
            int e2 = edge[1];
            Node n1 = null;
            Node n2 = null;
            if (map.containsKey(e1)) {
                n1 = map.get(e1);
            } else {
                n1 = new Node(e1);
                map.put(e1, n1);
            }
            if (map.containsKey(e2)) {
                n2 = map.get(e2);
            } else {
                n2 = new Node(e2);
                map.put(e2, n2);
            }
            Node p1 = n1.p;
            Node p2 = n2.p;
            if (p1 == null && p2 == null) {
                n2.p = n1;
            } else {
                if (p2 != null) {
                    twoParent = edge;
                    continue;
                }
                Node p = n1;
                while (p != null) {
                    if (p == n2) {
                        hasCycle = true;
                        break;
                    }
                    p = p.p;
                }
                if (hasCycle) {
                    last = edge;
                } else {
                    n2.p = n1;
                }
            }
        }
        if (twoParent == null) {
            return last;
        }
        if (!hasCycle) {
            return twoParent;
        } else {
            int[] result = new int[2];
            result[0] = map.get(twoParent[1]).p.i;
            result[1] = twoParent[1];
            return result;
        }
    }
}