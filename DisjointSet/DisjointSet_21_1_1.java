package DisjointSet;

import java.util.HashSet;

public class DisjointSet_21_1_1 {
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

    public static void main(String[] args) {
        DisjointSet_21_1_1 d = new DisjointSet_21_1_1();
        d.demo();
    }

    public void demo() {
        char[] vertices = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
        char[][] edges = {{'d', 'i'}, {'f', 'k'}, {'g', 'i'}, {'b', 'g'}, {'a', 'h'}, {'i', 'j'}, {'d', 'k'}, {'b', 'j'}, {'d', 'f'}, {'g', 'j'}, {'a', 'e'}};
        Graph g = new Graph(vertices, edges);
        CONNECTED_COMPONENTS(g);
    }

    HashSet<HashSet<Object>> set;

    public void CONNECTED_COMPONENTS(Graph g) {
        this.set = new HashSet<>();
        for (char v : g.vertices) {
            MAKE_SET(v);
        }
        System.out.println("Before Iteration on edges:");
        printComponent();
        for (char[] edge : g.edges) {
            HashSet<Object> s1 = FIND_SET(edge[0]);
            HashSet<Object> s2 = FIND_SET(edge[1]);
            if (s1 != s2) {
                UNION(edge[0], edge[1]);
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
        HashSet<Object> set1 = new HashSet<>();
        set1.add(o);
        this.set.add(set1);
    }

    public HashSet<Object> FIND_SET(Object o) {
        for (HashSet<Object> s : this.set) {
            if (s.contains(o)) {
                return s;
            }
        }
        return null;
    }

    public void UNION(Object o1, Object o2) {
        HashSet<Object> s1 = FIND_SET(o1);
        HashSet<Object> s2 = FIND_SET(o2);
        s1.addAll(s2);

        HashSet<HashSet<Object>> newSet = new HashSet<>();
        for (HashSet<Object> s : set) {
            if (s != s2) {
                newSet.add(s);
            }
        }
        set = newSet;
    }

    public void printComponent() {
        int i = 0;
        for (HashSet<Object> s : this.set) {
            System.out.print("Component " + i + " : (");
            int j = 0;
            for (Object o : s) {
                if (j == s.size() - 1) {
                    System.out.println(o + ")");
                } else {
                    System.out.print(o + ", ");
                }
                j++;
            }
            i++;
        }
    }
}
