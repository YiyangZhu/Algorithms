package UnionFind;

import java.util.*;

public class AccountMerge {
    public static void main(String[] args) {
        AccountMerge a = new AccountMerge();
        a.demo();
    }

    private void demo() {

        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>(Arrays.asList("David", "David0@m.co", "David1@m.co"));
        List<String> account2 = new ArrayList<>(Arrays.asList("David", "David3@m.co", "David4@m.co"));
        List<String> account3 = new ArrayList<>(Arrays.asList("David", "David4@m.co", "David5@m.co"));
        List<String> account4 = new ArrayList<>(Arrays.asList("David", "David2@m.co", "David3@m.co"));
        List<String> account5 = new ArrayList<>(Arrays.asList("David", "David1@m.co", "David2@m.co"));
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);
        System.out.println(accountsMerge(accounts));
    }

    public class Node {
        Node head;
        Node next;
        String s;

        Node(String s) {
            this.s = s;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Set<Node> names = new HashSet<>();
        Set<Node> emailSet = new HashSet<>();
        for (List<String> l : accounts) {
            String name = l.get(0);
            Node nameNode = new Node(name);
            makeSet(nameNode);
            names.add(nameNode);
            for (int i = 1; i < l.size(); i++) {
                Node eNode = new Node(l.get(i));
                makeSet(eNode);
                emailSet.add(eNode);
                Node p1 = findSet(nameNode);
                Node p2 = findSet(eNode);
                if (p1 != p2) {
                    union(p1, p2);

                }
            }
        }

        for (Node n1 : emailSet) {
            for (Node n2 : emailSet) {
                if (n1.s.equals(n2.s)) {
                    Node p1 = findSet(n1);
                    Node p2 = findSet(n2);
                    if (p1 != p2) {
                        unionNames(p1, p2);
                        names.remove(p2);
                    }
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Node n : names) {

            Node head = n;
            n = n.next;
            Set<String> set1 = new HashSet<>();
            while (n != null) {
                set1.add(n.s);
                n = n.next;
            }
            LinkedList<String> list1 = new LinkedList<>(set1);
            Collections.sort(list1);
            list1.addFirst(head.s);
            result.add(list1);
        }
        return result;
    }

    private void makeSet(Node n) {
        n.head = n;
    }

    private Node findSet(Node n) {
        return n.head;
    }

    private void union(Node n1, Node n2) {
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

    private void unionNames(Node n1, Node n2) {
        n2 = n2.next;
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
}