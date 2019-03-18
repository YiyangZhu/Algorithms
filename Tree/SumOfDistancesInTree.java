package Tree;

import java.util.ArrayList;
import java.util.HashSet;

public class SumOfDistancesInTree {
    ArrayList<HashSet<Integer>> tree;
    int[] count;
    int[] res;
    int n;

    public static void main(String[] args) {
        SumOfDistancesInTree s = new SumOfDistancesInTree();
        s.demo();
    }

    private void demo() {
        int N = 6;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[] a = sumOfDistancesInTree(N, edges);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        count = new int[N];
        res = new int[N];
        n = N;
        for (int i = 0; i < N; i++) {
            tree.add(new HashSet<Integer>());
        }
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        //System.out.println("begin dfs " + "root=" + 0 + ",seen = new HashSet<Integer>()");
        dfs(0, new HashSet<Integer>());
        System.out.println("begin dfs2 " + "root=" + 0 + ",seen = new HashSet<Integer>()");
        dfs2(0, new HashSet<Integer>());
        System.out.println("end dfs2 " + "root=" + 0 + ",seen = new HashSet<Integer>()");
        return res;
    }

    public void dfs(int root, HashSet<Integer> seen) {
        seen.add(root);
        //System.out.println("root=" + root + ",seen" + seen);
        for (int i : tree.get(root)) {
            if (!seen.contains(i)) {
                //System.out.println("begin dfs " + "root=" + i + ",seen=" + seen);
                dfs(i, seen);
                //System.out.println("end dfs " + "root=" + i + ",seen=" + seen);
                count[root] += count[i];
                //System.out.println("count[root]=" + count[root]);
                res[root] += res[i] + count[i];
                //System.out.println("res[root]=" + res[root]);
            }
        }
        count[root]++;
        //System.out.println("root=" + root + ",count[root]=" + count[root]);
    }

    public void dfs2(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root)) {
            if (!seen.contains(i)) {
                res[i] = res[root] - count[i] + n - count[i];
                System.out.println("res[i] = " +res[i]  + "i=" + i + ",seen=" + seen);
                System.out.println("begin dfs " + "i=" + i + ",seen=" + seen);
                dfs2(i, seen);
                System.out.println("end dfs " + "i=" + i + ",seen=" + seen);
            }
        }
    }
}