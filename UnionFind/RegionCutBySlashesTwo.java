package UnionFind;

import java.util.HashSet;

public class RegionCutBySlashesTwo {

    public static void main(String[] args) {
        RegionCutBySlashesTwo r = new RegionCutBySlashesTwo();
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

    HashSet<HashSet<Integer>> set;
    int len;

    public int regionsBySlashes(String[] grid) {
        int result = 1;
        this.set = new HashSet<>();
        int n = grid.length;
        this.len = n + 1;
        int[][] matrix = new int[len][len];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                MAKE_SET(i, j);
            }
        }
        //merge outer sets
        //left and right
        for (int i = 0; i < n; i++) {
            HashSet<Integer> s1 = FIND_SET(i, 0);
            HashSet<Integer> s2 = FIND_SET(i + 1, 0);
            if (s1 != s2) {
                UNION(s1, s2);
            }
            HashSet<Integer> s3 = FIND_SET(i, n);
            HashSet<Integer> s4 = FIND_SET(i + 1, n);
            if (s3 != s4) {
                UNION(s3, s4);
            }
        }

        //top and bottom
        for (int j = 0; j < n; j++) {
            HashSet<Integer> s1 = FIND_SET(0, j);
            HashSet<Integer> s2 = FIND_SET(0, j + 1);
            if (s1 != s2) {
                UNION(s1, s2);
            }
            HashSet<Integer> s3 = FIND_SET(n, j);
            HashSet<Integer> s4 = FIND_SET(n, j + 1);
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
                    HashSet<Integer> s1 = FIND_SET(row, col);
                    HashSet<Integer> s2 = FIND_SET(row2, col2);
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
                    HashSet<Integer> s1 = FIND_SET(row, col);
                    HashSet<Integer> s2 = FIND_SET(row2, col2);
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

    private void MAKE_SET(int i, int j) {
        HashSet<Integer> s = new HashSet();
        int index = i * len + j;
        s.add(index);
        this.set.add(s);
    }

    private HashSet<Integer> FIND_SET(int i, int j) {
        int index = i * len + j;
        for (HashSet<Integer> s : this.set) {
            if (s.contains(index)) {
                return s;
            }
        }
        return null;
    }

    private void UNION(HashSet<Integer> s1, HashSet<Integer> s2) {
        s1.addAll(s2);
        HashSet<HashSet<Integer>> newSet = new HashSet<>();
        for (HashSet<Integer> s : this.set) {
            if (s != s2) {
                newSet.add(s);
            }
        }
        this.set = newSet;
    }

    public void printComponent() {
        int i = 0;
        for (HashSet<Integer> s : this.set) {
            System.out.print("Component " + i + " : { ");
            int j = 0;
            for (int a : s) {
                System.out.print(a + " ");
            }
            i++;
            System.out.println(" }");
        }
        System.out.println();
    }
}
