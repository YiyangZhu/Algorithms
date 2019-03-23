package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphBFS {
    public class Graph {
        List<Vertex> vertices;
        List<Edge> edges;

        public Graph() {

        }

        public Graph(List<Vertex> vertices, List<Edge> edges) {
            this.vertices = vertices;
            this.edges = edges;
        }
    }

    public class Vertex {
        char c;
        String color;
        int d;
        Vertex pi;

        public Vertex(char c) {
            this.c = c;
        }
    }

    public class Edge {
        Vertex start;
        Vertex end;

        public Edge(Vertex s, Vertex e) {
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) {
        GraphBFS g = new GraphBFS();
        g.demo();
    }


    private void demo() {
        List<Vertex> vertices = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
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
        edges.add(new Edge(r, s));
        edges.add(new Edge(s, r));
        edges.add(new Edge(r, v));
        edges.add(new Edge(v, r));
        edges.add(new Edge(s, w));
        edges.add(new Edge(w, s));
        edges.add(new Edge(w, t));
        edges.add(new Edge(t, w));
        edges.add(new Edge(w, x));
        edges.add(new Edge(x, w));
        edges.add(new Edge(t, x));
        edges.add(new Edge(x, t));
        edges.add(new Edge(x, y));
        edges.add(new Edge(y, x));
        edges.add(new Edge(u, y));
        edges.add(new Edge(y, u));
        edges.add(new Edge(t, u));
        edges.add(new Edge(u, t));
        edges.add(new Edge(u, x));
        edges.add(new Edge(x, u));
        Graph g = new Graph(vertices, edges);
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
            for (Edge edge : g.edges) {
                if (edge.start == u) {
                    Vertex v = edge.end;
                    if (v.color.equals("WHITE")) {
                        v.d = u.d + 1;
                        v.pi = u;
                        v.color = "GRAY";
                        q.offer(v);
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
