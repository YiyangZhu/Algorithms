package DisjointSet;

import java.util.HashSet;

public class DisjointSet_21_2_2 {

    public class Node {
        int val;
        Node next;
        Node head;

        Node(int i) {
            this.val = i;
        }
    }

    public class LinkedList {
        Node head;
        Node tail;
        int size;

        public LinkedList() {
            size = 0;
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
            size++;
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
        DisjointSet_21_2_2 d = new DisjointSet_21_2_2();
        d.demo();
    }

    HashSet<LinkedList> set;

    public void demo() {
        set = new HashSet<>();
        for (int i = 1; i <= 16; i++) {
            MAKE_SET(i);
        }
        System.out.println("After MAKE-SET operations:");
        printComponent();

        for (int i = 1; i <= 15; i += 2) {
            LinkedList l1 = FIND_SET(i);
            LinkedList l2 = FIND_SET(i + 1);
            System.out.println("\nBefore iteration on (" + i + ", " + (i + 1) + ")");
            printComponent();
            if (l1 != l2) {
                WEIGHTED_UNION(l1, l2);
            }
            System.out.println("After iteration on (" + i + ", " + (i + 1) + ")");
            printComponent();
        }

        for (int i = 1; i <= 13; i += 4) {
            LinkedList l1 = FIND_SET(i);
            LinkedList l2 = FIND_SET(i + 2);
            System.out.println("\nBefore iteration on (" + i + ", " + (i + 2) + ")");
            printComponent();
            if (l1 != l2) {
                WEIGHTED_UNION(l1, l2);
            }
            System.out.println("After iteration on (" + i + ", " + (i + 2) + ")");
            printComponent();
        }

        System.out.println("\nBefore union (" + 1 + ", " + 5 + ")");
        printComponent();
        LinkedList l1 = FIND_SET(1);
        LinkedList l2 = FIND_SET(5);
        WEIGHTED_UNION(l1, l2);
        System.out.println("After union (" + 1 + ", " + 5 + ")");
        printComponent();

        System.out.println("\nBefore union (" + 11 + ", " + 13 + ")");
        printComponent();
        LinkedList l3 = FIND_SET(11);
        LinkedList l4 = FIND_SET(13);
        WEIGHTED_UNION(l3, l4);
        System.out.println("After union (" + 11 + ", " + 13 + ")");
        printComponent();

        System.out.println("\nBefore union (" + 1 + ", " + 10 + ")");
        printComponent();
        LinkedList l5 = FIND_SET(1);
        LinkedList l6 = FIND_SET(10);
        WEIGHTED_UNION(l5, l6);
        System.out.println("After union (" + 1 + ", " + 10 + ")");
        printComponent();

        LinkedList l7 = FIND_SET(2);
        LinkedList l8 = FIND_SET(9);
        printLinkedList(l7);
        printLinkedList(l8);
    }


    public void MAKE_SET(Object o) {
        LinkedList l = new LinkedList();
        Node n = new Node((int) o);
        l.insert(n);
        this.set.add(l);
    }

    public LinkedList FIND_SET(Object o) {
        for (LinkedList l : this.set) {
            Node n = l.head;
            while (n != null) {
                if (n.val == (int) o) {
                    return l;
                }
                n = n.next;
            }
        }
        return null;
    }

    public void WEIGHTED_UNION(LinkedList l1, LinkedList l2) {
        int size1 = l1.size;
        int size2 = l2.size;
        Node n;
        LinkedList l0;
        LinkedList lToRemove;
        if (size1 >= size2) {
            n = l2.head;
            l0 = l1;
            lToRemove = l2;
        } else {
            n = l1.head;
            l0 = l2;
            lToRemove = l1;
        }
        System.out.println("l0.size=" + l0.size);
        System.out.println("lToRemove.size=" + lToRemove.size);
        while (n != null) {
            l0.insert(n);
            n = n.next;
        }
        HashSet<LinkedList> newSet = new HashSet<>();
        for (LinkedList l : this.set) {
            if (l != lToRemove) {
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
