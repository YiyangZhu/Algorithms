package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListRep {
    public class Graph {
        List<Vertex>[] edges;
        List<Vertex> vertices;

        public Graph(List<Vertex>[] edges, List<Vertex> vertices) {
            this.edges = edges;
            this.vertices = vertices;
        }
    }

    public class Vertex {
        Vertex pi;
        int d;
        String color;
        char c;

        Vertex(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        ListRep l = new ListRep();
        l.demo();
    }

    private void demo() {
        List<Vertex> vertices = new ArrayList<>();
        List<Vertex>[] edges = new ArrayList[8];
        Vertex r = new Vertex('r');
        Vertex s = new Vertex('s');
        Vertex t = new Vertex('t');
        Vertex u = new Vertex('u');
        Vertex v = new Vertex('v');
        Vertex w = new Vertex('w');
        Vertex x = new Vertex('x');
        Vertex y = new Vertex('y');
        vertices.add(r);
        vertices.add(s);
        vertices.add(t);
        vertices.add(u);
        vertices.add(v);
        vertices.add(w);
        vertices.add(x);
        vertices.add(y);
        edges[0] = new ArrayList<>();
        edges[0].add(s);
        edges[0].add(r);
        edges[0].add(w);
        edges[1] = new ArrayList<>();
        edges[1].add(r);
        edges[1].add(s);
        edges[1].add(v);
        edges[2] = new ArrayList<>();
        edges[2].add(w);
        edges[2].add(s);
        edges[2].add(t);
        edges[2].add(x);
        edges[3] = new ArrayList<>();
        edges[3].add(t);
        edges[3].add(w);
        edges[3].add(u);
        edges[3].add(x);
        edges[4] = new ArrayList<>();
        edges[4].add(x);
        edges[4].add(w);
        edges[4].add(t);
        edges[4].add(u);
        edges[4].add(y);
        edges[5] = new ArrayList<>();
        edges[5].add(u);
        edges[5].add(t);
        edges[5].add(x);
        edges[5].add(y);
        edges[6] = new ArrayList<>();
        edges[6].add(y);
        edges[6].add(u);
        edges[6].add(x);
        edges[7] = new ArrayList<>();
        edges[7].add(v);
        edges[7].add(r);
        Graph g = new Graph(edges, vertices);
        bfs(g);

    }

    public void bfs(Graph g) {
        //set distinguished source vertex s
        Vertex s = null;
        for (Vertex v : g.vertices) {
            if (v.c == 's') {
                s = v;
                break;
            }
        }
        //initialize each vertex
        for (Vertex v : g.vertices) {
            if (v != s) {
                v.color = "WHITE";
                v.d = Integer.MAX_VALUE;
                v.pi = null;
            }
        }
        System.out.println("\nbefore initialize source vertex, graph is");
        printGraph(g);
        //initlize source vertex
        s.d = 0;
        s.pi = null;
        s.color = "GRAY";
        //initialize queue
        LinkedList<Vertex> q = new LinkedList<>();
        q.offer(s);
        System.out.println("\nbefore loop, after initialize source vertex, graph is");
        printGraph(g);
        int i = 0;
        while (!q.isEmpty()) {
            System.out.println("\n" + i + "th iteration" + " starts, graph is");
            printGraph(g);
            Vertex u = q.poll();
            for (List edge : g.edges) {
                if (edge.get(0) == u) {
                    for (int j = 1; j < edge.size(); j++) {
                        Vertex v = (Vertex) edge.get(j);
                        if (v.color.equals("WHITE")) {
                            v.color = "GRAY";
                            v.d = u.d + 1;
                            v.pi = u;
                            q.add(v);
                        }
                    }
                }
            }
            u.color = "BLACK";
            System.out.println("\n" + i + "th iteration" + " ends, graph is");
            printGraph(g);
            i++;
        }
        System.out.println("\nAfter loop, graph is");
        printGraph(g);
    }

    private void printGraph(Graph g) {
        for (Vertex v : g.vertices) {
            System.out.println("Vertex = " + v.c + " , distance = " + v.d + " color = " + v.color + ", pi = " + (v.pi == null ? "null" : v.pi.c));
        }
    }
}
