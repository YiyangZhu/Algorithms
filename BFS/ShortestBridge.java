package BFS;

import java.util.*;

public class ShortestBridge {
    public int shortestBridge(int[][] A) {
        int n = A.length;
        Set<Integer> set = new HashSet<>();
        int firstRow = 0;
        int firstCol = 0;
        A:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    merge(A, i, j, set);
                    firstRow = i;
                    firstCol = j;
                    break A;
                }
            }
        }
        boolean[][] visited = new boolean[n][n];
        boolean[][] checked = new boolean[n][n];
        LinkedList<int[]> q = new LinkedList<>();
        int[] array3 = new int[3];
        array3[0] = firstRow;
        array3[1] = firstCol;
        array3[2] = -1;
        q.offer(array3);
        checked[firstRow][firstCol] = true;
        int result = 0;
        while (!q.isEmpty()) {
            int[] array = q.poll();
            int i = array[0];
            int j = array[1];
            visited[i][j] = true;
            int currentD = array[2];
            if (i < n - 1) {
                result = enqueue(i + 1, j, q, set, visited, checked, n, A, currentD);
                if (result > 0) {
                    return result;
                }
            }
            if (j >= 1) {
                result = enqueue(i, j - 1, q, set, visited, checked, n, A, currentD);
                if (result > 0) {
                    return result;
                }
            }
            if (j < n - 1) {
                result = enqueue(i, j + 1, q, set, visited, checked, n, A, currentD);
                if (result > 0) {
                    return result;
                }
            }
        }
        return result;
    }

    private void merge(int[][] A, int i, int j, Set<Integer> set) {
        int n = A.length;
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return;
        }
        if (A[i][j] == 0) {
            return;
        }
        int index = i * n + j;
        if (set.contains(index)) {
            return;
        }
        set.add(index);
        merge(A, i - 1, j, set);
        merge(A, i + 1, j, set);
        merge(A, i, j - 1, set);
        merge(A, i, j + 1, set);
    }

    private int enqueue(int i, int j, LinkedList<int[]> q, Set<Integer> set, boolean[][] visited, boolean[][] checked, int n, int[][] A, int currentD) {
        if (!visited[i][j]) {
            int indexDown = n * (i) + j;
            if (!set.contains(indexDown)) {
                if (A[i][j] == 1) {
                    return currentD + 1;
                } else if (!checked[i][j]) {
                    int[] a3 = new int[3];
                    a3[0] = i;
                    a3[1] = j;
                    a3[2] = currentD + 1;
                    q.offer(a3);
                    checked[i][j] = true;
                }
            } else if (!checked[i][j]) {
                int[] a3 = new int[3];
                a3[0] = i;
                a3[1] = j;
                a3[2] = -1;
                q.offerFirst(a3);
                checked[i][j] = true;
            }
        }
        return -1;
    }
}