package DisjointSet;

import java.util.HashSet;
import java.util.Set;

public class Demo {
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
        Demo m = new Demo();
        m.demo();
    }

    public void demo() {
        char[] vertices = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        char[][] edges = {{'b', 'd'}, {'e', 'g'}, {'a', 'c'}, {'h', 'i'}, {'a', 'b'}, {'e', 'f'}, {'b', 'c'}};
        Graph g = new Graph(vertices, edges);
        CONNECTED_COMPONENTS(g);
        System.out.println(SAME_COMPONENT('a', 'b'));
        System.out.println(SAME_COMPONENT('a', 'e'));
    }

    public void CONNECTED_COMPONENTS(Graph g) {
        set = new HashSet<>();
        for (char v : g.vertices) {
            MAKE_SET(v);
        }
        //above statement time complexity: O(|V|)
        for (char[] edge : g.edges) {
            HashSet<Object> set1 = FIND_SET(edge[0]);
            HashSet<Object> set2 = FIND_SET(edge[1]);
            if (set1 != set2) {
                UNION(edge[0], edge[1]);
            }
        }
        //above statements time complexity (worst case): O(|E| * set.size() * O(set2.size()?))
    }

    public boolean SAME_COMPONENT(char u, char v) {
        if (FIND_SET(u) == FIND_SET(v)) {
            return true;
        } else {
            return false;
        }
    }

    Set<HashSet<Object>> set;

    //MAKE-SET
    public void MAKE_SET(Object o) {
        HashSet<Object> set1 = new HashSet<>();
        set1.add(o);
        set.add(set1);
    }

    //FIND-SET
    public HashSet<Object> FIND_SET(Object o) {
        for (HashSet<Object> s : set) {
            if (s.contains(o)) {
                return s;
            }
        }
        return null;
    }

    //UNION
    public void UNION(Object o1, Object o2) {
        HashSet<Object> set1 = FIND_SET(o1);
        HashSet<Object> set2 = FIND_SET(o2);
        set1.addAll(set2);
        /*
        The above statement can also be written as:
        for (Object o : set2) {
            set1.add(set2);
        }
        */
        set.remove(set2);
    }
}
