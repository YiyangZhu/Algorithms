package Graph;

import java.util.*;

public class MatrixRep {

    public class Graph {
        int[][] matrix;
        List<Vertex> vertices;
        Map<Integer, Vertex> map;

        public Graph(int[][] matrix, List<Vertex> vertices, Map<Integer, Vertex> map) {
            this.matrix = matrix;
            this.vertices = vertices;
            this.map = map;
        }
    }

    public class Vertex {
        Vertex pi;
        int d;
        String color;
        char c;
        int position;

        Vertex(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        MatrixRep m = new MatrixRep();
        m.demo();
    }

    private void demo() {
        List<Vertex> vertices = new ArrayList<>();
        int[][] matrix = new int[8][8];
        Map<Integer, Vertex> map = new HashMap<>();
        Vertex r = new Vertex('r');
        r.position = 0;
        map.put(0, r);
        Vertex s = new Vertex('s');
        s.position = 1;
        map.put(1, s);
        Vertex t = new Vertex('t');
        t.position = 2;
        map.put(2, t);
        Vertex u = new Vertex('u');
        u.position = 3;
        map.put(3, u);
        Vertex v = new Vertex('v');
        v.position = 4;
        map.put(4, v);
        Vertex w = new Vertex('w');
        w.position = 5;
        map.put(5, w);
        Vertex x = new Vertex('x');
        x.position = 6;
        map.put(6, x);
        Vertex y = new Vertex('y');
        y.position = 7;
        map.put(7, y);
        vertices.add(r);
        vertices.add(s);
        vertices.add(t);
        vertices.add(u);
        vertices.add(v);
        vertices.add(w);
        vertices.add(x);
        vertices.add(y);
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        matrix[0][4] = 1;
        matrix[4][0] = 1;
        matrix[1][5] = 1;
        matrix[5][1] = 1;
        matrix[2][5] = 1;
        matrix[5][2] = 1;
        matrix[5][6] = 1;
        matrix[6][5] = 1;
        matrix[6][2] = 1;
        matrix[2][6] = 1;
        matrix[3][2] = 1;
        matrix[2][3] = 1;
        matrix[3][7] = 1;
        matrix[7][3] = 1;
        matrix[3][6] = 1;
        matrix[6][3] = 1;
        matrix[6][7] = 1;
        matrix[7][6] = 1;
        Graph g = new Graph(matrix, vertices, map);
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
            int row = u.position;
            for (int j = 0; j < g.matrix.length; j++) {
                if (g.matrix[row][j] == 1) {
                    Vertex v = g.map.get(j);
                    if (v.color.equals("WHITE")) {
                        v.color = "GRAY";
                        v.d = u.d + 1;
                        v.pi = u;
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

