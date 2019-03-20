package UnionFind;

import java.util.HashSet;

public class RegionCutBySlashes {

    public static void main(String[] args) {
        RegionCutBySlashes r = new RegionCutBySlashes();
        r.demo();
    }

    public void demo() {
        String[] grid = {" /", "/ "};
        System.out.println(regionsBySlashes(grid));
        String[] grid2 = {" /", "  "};
        System.out.println(regionsBySlashes(grid2));
        String[] grid3 = {"\\/", "/\\"};
        System.out.println(regionsBySlashes(grid3));
        String[] grid4 = {"/\\", "\\/"};
        System.out.println(regionsBySlashes(grid4));
        String[] grid5 = {"//", "/ "};
        System.out.println(regionsBySlashes(grid5));
    }

    HashSet<HashSet<int[]>> set;

    public int regionsBySlashes(String[] grid) {
        int result = 1;
        set = new HashSet<>();
        int n = grid.length;
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int[] a = {i, j};
                MAKE_SET(a);
            }
        }
        //merge outer sets
        //left and right
        for (int i = 0; i < n; i++) {
            HashSet<int[]> s1 = FIND_SET(i, 0);
            HashSet<int[]> s2 = FIND_SET(i + 1, 0);
            if (s1 != s2) {
                UNION(s1, s2);
            }
            HashSet<int[]> s3 = FIND_SET(i, n);
            HashSet<int[]> s4 = FIND_SET(i + 1, n);
            if (s3 != s4) {
                UNION(s3, s4);
            }
        }

        //top and bottom
        for (int j = 0; j < n; j++) {
            HashSet<int[]> s1 = FIND_SET(0, j);
            HashSet<int[]> s2 = FIND_SET(0, j + 1);
            if (s1 != s2) {
                UNION(s1, s2);
            }
            HashSet<int[]> s3 = FIND_SET(n, j);
            HashSet<int[]> s4 = FIND_SET(n, j + 1);
            if (s3 != s4) {
                UNION(s3, s4);
            }
        }

        for (int i = 0; i < n; i++) {
            String s = grid[i];
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == '/') {
                    int row = i + 1;
                    int col = j;
                    int row2 = i;
                    int col2 = j + 1;
                    HashSet<int[]> s1 = FIND_SET(row, col);
                    HashSet<int[]> s2 = FIND_SET(row2, col2);
                    if (s1 == s2) {
                        result++;
                    } else {
                        UNION(s1, s2);
                    }
                } else if (c == '\\') {
                    int row = i;
                    int col = j;
                    int row2 = i + 1;
                    int col2 = j + 1;
                    HashSet<int[]> s1 = FIND_SET(row, col);
                    HashSet<int[]> s2 = FIND_SET(row2, col2);
                    if (s1 == s2) {
                        result++;
                    } else {
                        UNION(s1, s2);
                    }
                }

            }
        }
        return result;
    }

    private void MAKE_SET(int[] a) {
        HashSet<int[]> s = new HashSet();
        s.add(a);
        this.set.add(s);
    }

    private HashSet<int[]> FIND_SET(int row, int col) {
        for (HashSet<int[]> s : this.set) {
            for (int[] a1 : s) {
                if (a1[0] == row && a1[1] == col) {
                    return s;
                }
            }
        }
        return null;
    }

    private void UNION(HashSet<int[]> s1, HashSet<int[]> s2) {
        s1.addAll(s2);
        HashSet<HashSet<int[]>> newSet = new HashSet<>();
        for (HashSet<int[]> s : this.set) {
            if (s != s2) {
                newSet.add(s);
            }
        }
        this.set = newSet;
    }

    public void printComponent() {
        int i = 0;
        for (HashSet<int[]> s : this.set) {
            System.out.print("Component " + i + " : { ");
            int j = 0;
            for (int[] a : s) {
                System.out.print("(");
                System.out.print(a[0] + " " + a[1]);
                System.out.print(") ");
            }
            i++;
            System.out.println(" }");
        }
        System.out.println();
    }
}
