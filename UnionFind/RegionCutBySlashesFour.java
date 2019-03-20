package UnionFind;

import java.util.HashMap;

public class RegionCutBySlashesFour {

    public static void main(String[] args) {
        RegionCutBySlashesFour r = new RegionCutBySlashesFour();
        r.demo();
    }

    public void demo() {
        String[] grid = {" /", "/ "};
        System.out.println(regionsBySlashes(grid));
        String[] grid2 = {" /", "  "};
        System.out.println(regionsBySlashes(grid2));
        String[] grid3 = {"\\/", "/\\"};
        System.out.println(regionsBySlashes(grid3));
        String[] grid4 = {"/\\", "\\/"};
        System.out.println(regionsBySlashes(grid4));
        String[] grid5 = {"//", "/ "};
        System.out.println(regionsBySlashes(grid5));
    }


    public int regionsBySlashes(String[] grid) {
        int result = 1;
        HashMap<Integer, Node> map = new HashMap<>();
        int n = grid.length;
        int index = (n + 1) * (n + 1);

        //make-set
        for (int i = 0; i < index; i++) {
            Node n1 = new Node(i);
            map.put(i, n1);
            MAKE_SET(n1);
        }

        //merge outer nodes
        //top
        for (int i = 0; i < n; i++) {
            Node t1 = map.get(i).head;
            Node t2 = map.get(i + 1).head;
            if (t1 != t2) {
                UNION(t1, t2);
            }
        }
        //bottom
        for (int i = n * (n + 1); i < index - 1; i++) {
            Node t1 = map.get(i).head;
            Node t2 = map.get(i + 1).head;
            if (t1 != t2) {
                UNION(t1, t2);
            }
        }
        //left
        for (int j = 0; j < n; j++) {
            Node t1 = map.get(j * (n + 1)).head;
            Node t2 = map.get((j + 1) * (n + 1)).head;
            if (t1 != t2) {
                UNION(t1, t2);
            }
        }
        //right
        for (int j = 0; j < n; j++) {
            Node t1 = map.get(j * (n + 1) + n).head;
            Node t2 = map.get((j + 1) * (n + 1) + n).head;
            if (t1 != t2) {
                UNION(t1, t2);
            }
        }

        for (int i = 0; i < n; i++) {
            String s = grid[i];
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == '/') {
                    int index1 = (i + 1) * (n + 1) + j;
                    int index2 = i * (n + 1) + j + 1;
                    Node t1 = map.get(index1);
                    Node t2 = map.get(index2);
                    Node p1 = FIND_SET(t1);
                    Node p2 = FIND_SET(t2);
                    if (p1 == p2) {
                        result++;
                    } else {
                        UNION(p1, p2);
                    }
                } else if (c == '\\') {
                    int index1 = i * (n + 1) + j;
                    int index2 = (i + 1) * (n + 1) + j + 1;
                    Node t1 = map.get(index1);
                    Node t2 = map.get(index2);
                    Node p1 = FIND_SET(t1);
                    Node p2 = FIND_SET(t2);
                    if (p1 == p2) {
                        result++;
                    } else {
                        UNION(p1, p2);
                    }
                }
            }
        }

        return result;
    }

    private void MAKE_SET(Node n1) {
        n1.head = n1;
    }

    private Node FIND_SET(Node n1) {
        return n1.head;
    }

    private void UNION(Node n1, Node n2) {
        Node tail = n1;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = n2;
        while (n2 != null) {
            n2.head = n1;
            n2 = n2.next;
        }
    }

    public class Node {
        int val;
        Node head;
        Node next;

        public Node() {

        }

        public Node(int i) {
            this.val = i;
        }
    }
}