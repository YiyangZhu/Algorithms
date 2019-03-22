package UnionFind;

import java.util.*;

public class AccountMerge {
    public static void main(String[] args) {
        AccountMerge a = new AccountMerge();
        a.demo();
    }

    private void demo() {

        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>(Arrays.asList("David", "David0@m.co", "David0@m.co", "David1@m.co"));
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
        Node p;
        int rank;
        String name;
        List<String> accounts;

        public Node(String s) {
            this.name = s;
        }
    }

    private void makeSet(Node n) {
        n.p = n;
        n.rank = 0;
        n.accounts = new ArrayList<>();
    }

    private Node findSet(Node n) {
        if (n != n.p) {
            n.p = findSet(n.p);
        }
        return n.p;
    }

    private void union(Node n1, Node n2) {
        if (n1.rank > n2.rank) {
            n2.p = n1;
        } else {
            n1.p = n2;
            if (n1.rank == n2.rank) {
                n2.rank++;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Node> map = new HashMap<>();
        List<Node> allNodes = new ArrayList<>();
        for (List<String> current : accounts) {
            String name = current.get(0);
            Node n = new Node(name);
            makeSet(n);
            for (int i = 1; i < current.size(); i++) {
                String email = current.get(i);
                if (!map.containsKey(email)) {
                    n.accounts.add(email);
                    map.put(email, n);
                } else {
                    Node p1 = findSet(n);
                    Node p2 = findSet(map.get(email));
                    if (p1 != p2) {
                        union(p1, p2);
                    }
                }
            }
            allNodes.add(n);
        }

        for (Node n : allNodes) {
            if (n.p != n) {
                Node p1 = findSet(n.p);
                p1.accounts.addAll(n.accounts);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Node n : allNodes) {
            if (n.p == n) {
                List<String> l = new ArrayList<>();
                l.add(n.name);
                Collections.sort(n.accounts);
                l.addAll(n.accounts);
                result.add(l);
            }
        }
        return result;
    }
}