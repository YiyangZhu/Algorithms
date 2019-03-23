package BFS;

import java.util.*;

public class ShortestBridge {
    public int shortestBridge(int[][] A) {
        int n = A.length;
        Set<Integer> set = new HashSet<>();
        List<int[]> firstIsland = new ArrayList<>();
        boolean findOne = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    merge(A, i, j, set, firstIsland);
                    findOne = true;
                    break;
                }
            }
            if (findOne) {
                break;
            }
        }
        boolean[][] visited = new boolean[n][n];
        LinkedList<int[]> q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int[] a = firstIsland.get(0);
        int[] array3 = new int[3];
        array3[0] = a[0];
        array3[1] = a[1];
        array3[2] = -1;
        q.add(array3);
        while (!q.isEmpty()) {
            int[] array = q.poll();
            int i = array[0];
            int j = array[1];

            visited[i][j] = true;
            int currentD = array[2];
            if (i < n - 1) {
                int indexDown = n * (i + 1) + j;
                if (!set.contains(indexDown)) {
                    if (A[i + 1][j] == 1 && !visited[i + 1][j]) {
                        if (currentD + 1 < min) {
                            min = currentD + 1;
                        }
                    } else if (!visited[i + 1][j]) {
                        int[] a3 = new int[3];
                        a3[0] = i + 1;
                        a3[1] = j;
                        a3[2] = currentD + 1;
                        q.add(a3);
                    }
                } else if (!visited[i + 1][j]) {
                    int[] a3 = new int[3];
                    a3[0] = i + 1;
                    a3[1] = j;
                    a3[2] = -1;
                    q.add(a3);
                }
            }
            if (j >= 1) {
                int indexLeft = n * i + j - 1;
                if (!set.contains(indexLeft)) {
                    if (A[i][j - 1] == 1 && !visited[i][j - 1]) {
                        if (currentD + 1 < min) {
                            min = currentD + 1;
                        }
                    } else if (!visited[i][j - 1]) {
                        int[] a3 = new int[3];
                        a3[0] = i;
                        a3[1] = j - 1;
                        a3[2] = currentD + 1;
                        q.add(a3);
                    }
                } else if (!visited[i][j - 1]) {
                    int[] a3 = new int[3];
                    a3[0] = i;
                    a3[1] = j - 1;
                    a3[2] = -1;
                    q.add(a3);
                }
            }
            if (j < n - 1) {
                int indexRight = n * i + j + 1;
                if (!set.contains(indexRight)) {
                    if (A[i][j + 1] == 1 && !visited[i][j + 1]) {
                        if (currentD + 1 < min) {
                            min = currentD + 1;
                        }
                    } else if (!visited[i][j + 1]) {
                        int[] a3 = new int[3];
                        a3[0] = i;
                        a3[1] = j + 1;
                        a3[2] = currentD + 1;
                        q.add(a3);
                    }
                } else if (!visited[i][j + 1]) {
                    int[] a3 = new int[3];
                    a3[0] = i;
                    a3[1] = j + 1;
                    a3[2] = -1;
                    q.add(a3);
                }
            }
        }
        return min;
    }

    private void merge(int[][] A, int i, int j, Set<Integer> set, List<int[]> firstIsland) {
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
        int[] array = {i, j};
        firstIsland.add(array);
        merge(A, i - 1, j, set, firstIsland);
        merge(A, i + 1, j, set, firstIsland);
        merge(A, i, j - 1, set, firstIsland);
        merge(A, i, j + 1, set, firstIsland);
    }
}