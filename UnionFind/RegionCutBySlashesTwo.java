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

        HashSet<Integer> set0 = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            int j = 0;
            int index = len * i + j;
            set0.add(index);
            j = n;
            index = len * i + j;
            set0.add(index);
        }

        for (int j = 0; j <= n; j++) {
            int i = 0;
            int index = len * i + j;
            set0.add(index);
            i = n;
            index = len * i + j;
            set0.add(index);
        }
        set.add(set0);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                MAKE_SET(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            String s = grid[i];
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == '/') {
                    HashSet<Integer> s1 = FIND_SET(i + 1, j);
                    HashSet<Integer> s2 = FIND_SET(i, j + 1);
                    if (s1 == s2) {
                        result++;
                    } else {
                        UNION(s1, s2);
                    }
                } else if (c == '\\') {
                    HashSet<Integer> s1 = FIND_SET(i, j);
                    HashSet<Integer> s2 = FIND_SET(i + 1, j + 1);
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
