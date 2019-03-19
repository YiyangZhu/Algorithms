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

    HashSet<LinkedList> set;

    public void CONNECTED_COMPONENTS(Graph g) {
        this.set = new HashSet<>();
        for (char v : g.vertices) {
            MAKE_SET(v);
        }

        for (char[] edge : g.edges) {
            System.out.println("Before iteration on edge (" + edge[0] + "," + edge[1] + ")");
            printComponent();
            LinkedList l1 = FIND_SET(edge[0]);
            LinkedList l2 = FIND_SET(edge[1]);
            if (l1 != l2) {
                UNION(l1, l2);
            }
            System.out.println();
            System.out.println("After iteration on edge (" + edge[0] + "," + edge[1] + ")");
            printComponent();
        }
    }

    public boolean SAME_COMPONENT(Object o1, Object o2) {
        if (FIND_SET(o1) == FIND_SET(o2)) {
            return true;
        } else {
            return false;
        }
    }

    public void MAKE_SET(Object o) {
        LinkedList l = new LinkedList();
        Node n = new Node((char) o);
        l.insert(n);
        this.set.add(l);
    }

    public LinkedList FIND_SET(Object o) {
        for (LinkedList l : this.set) {

            Node n = l.head;

            while (n != null) {
                if (n.val == (char) o) {
                    return l;
                }
                n = n.next;
            }
        }
        return null;
    }

    public void UNION(LinkedList l1, LinkedList l2) {
        Node n = l2.head;
        Node n2 = l2.head;
        while (n2 != null) {
            n = n2;
            l1.insert(n);
            n2 = n2.next;
        }
        HashSet<LinkedList> newSet = new HashSet<>();
        for (LinkedList l : this.set) {
            if (l != l2) {

                newSet.add(l);
            }
        }
        this.set = newSet;
    }

    public void printComponent() {
        int i = 0;
        for (LinkedList l : this.set) {
            System.out.print("Component " + i + " : (");
            int j = 0;
            Node n = l.head;
            while (n != l.tail) {
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
