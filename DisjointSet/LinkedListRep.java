package DisjointSet;

import java.util.HashSet;

public class LinkedListRep {
    public class Graph {
        char[] vertices;
        char[][] edges;

        Graph() {
        }

        Graph(char[] vertices, char[][] edges) {
            this.vertices = vertices;
            this.edges = edges;
        }
    }

    public class Node {
        char val;
        Node next;
        Node head;

        Node(char c) {
            this.val = c;
        }
    }

    public class LinkedList {
        Node head;
        Node tail;

        public LinkedList() {
        }

        public void insert(Node n) {
            if (head == null) {
                head = n;
            } else {
                Node t = this.tail;
                t.next = n;
            }
            n.head = this.head;
            this.tail = n;
        }

        public Node search(int key) {
            Node n = head;
            while (n != this.tail) {
                if (n.val == key) {
                    return n;
                }
                n = n.next;
            }
            if (this.tail.val == key) {
                return tail;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        LinkedListRep l = new LinkedListRep();
        l.demo();
    }

    public void demo() {
        char[] vertices = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
        char[][] edges = {{'d', 'i'}, {'f', 'k'}, {'g', 'i'}, {'b', 'g'}, {'a', 'h'}, {'i', 'j'}, {'d', 'k'}, {'b', 'j'}, {'d', 'f'}, {'g', 'j'}, {'a', 'e'}};
        Graph g = new Graph(vertices, edges);
        CONNECTED_COMPONENTS(g);
    }

    HashSet<Node> set;

    public void CONNECTED_COMPONENTS(Graph g) {
        this.set = new HashSet<>();
        HashSet<Node> nodeSet = new HashSet<>();
        for (char v : g.vertices) {
            Node n = new Node(v);
            MAKE_SET(n);
            nodeSet.add(n);
        }
        for (char[] edge : g.edges) {
            System.out.println("\nBefore iteration on edge (" + edge[0] + "," + edge[1] + ")");
            printComponent();
            Node n1 = null, n2 = null;
            for (Node n : nodeSet) {
                if (n.val == edge[0]) {
                    n1 = FIND_SET(n);
                    break;
                }
            }
            for (Node n : nodeSet) {
                if (n.val == edge[1]) {
                    n2 = FIND_SET(n);
                    break;
                }
            }
            if (n1 != n2) {
                UNION(n1, n2);
            }
            System.out.println();
            System.out.println("After iteration on edge (" + edge[0] + "," + edge[1] + ")");
            printComponent();
        }
    }

    public boolean SAME_COMPONENT(Node n1, Node n2) {
        if (FIND_SET(n1) == FIND_SET(n2)) {
            return true;
        } else {
            return false;
        }
    }

    public void MAKE_SET(Node n) {
        LinkedList l = new LinkedList();
        l.insert(n);
        this.set.add(n);
    }

    public Node FIND_SET(Node n1) {
        return n1.head;
    }

    public void UNION(Node n1, Node n2) {
        set.remove(n2);
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

    public void printComponent() {
        int i = 0;
        for (Node n : this.set) {
            System.out.print("Component " + i + " : (");
            int j = 0;
            while (n.next != null) {
                System.out.print(n.val + ", ");
                n = n.next;
            }
            System.out.println(n.val + ")");
            i++;
        }
    }

    public void printLinkedList(LinkedList l) {
        Node n = l.head;
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }
}
