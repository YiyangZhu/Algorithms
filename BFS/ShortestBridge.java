package BFS;

import java.util.*;

public class ShortestBridge {
    public int shortestBridge(int[][] A) {
        int n = A.length;
        Set<Integer> set = new HashSet<>();
        int[] firstIsland = new int[2];
        boolean findOne = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    merge(A, i, j, set);
                    firstIsland[0] = i;
                    firstIsland[1] = j;
                    findOne = true;
                    break;
                }
            }
            if (findOne) {
                break;
            }
        }
        boolean[][] visited = new boolean[n][n];
        boolean[][] checked = new boolean[n][n];
        LinkedList<int[]> q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int[] array3 = new int[3];
        array3[0] = firstIsland[0];
        array3[1] = firstIsland[1];
        array3[2] = -1;
        q.add(array3);
        checked[firstIsland[0]][firstIsland[1]] = true;
        while (!q.isEmpty()) {
            int[] array = q.poll();
            int i = array[0];
            int j = array[1];


            visited[i][j] = true;
            int currentD = array[2];
            if (i < n - 1) {
                if (!visited[i + 1][j]) {
                    int indexDown = n * (i + 1) + j;
                    if (!set.contains(indexDown)) {
                        if (A[i + 1][j] == 1) {
                            if (currentD + 1 < min) {
                                min = currentD + 1;
                                break;
                            }
                        } else {
                            if (!checked[i + 1][j]) {
                                int[] a3 = new int[3];
                                a3[0] = i + 1;
                                a3[1] = j;
                                a3[2] = currentD + 1;
                                q.add(a3);
                                checked[i + 1][j] = true;
                            }
                        }
                    } else {
                        if (!checked[i + 1][j]) {
                            int[] a3 = new int[3];
                            a3[0] = i + 1;
                            a3[1] = j;
                            a3[2] = -1;
                            q.addFirst(a3);
                            checked[i + 1][j] = true;
                        }
                    }
                }
            }
            if (j >= 1) {
                if (!visited[i][j - 1]) {
                    int indexDown = n * (i) + j - 1;
                    if (!set.contains(indexDown)) {
                        if (A[i][j - 1] == 1) {
                            if (currentD + 1 < min) {
                                min = currentD + 1;
                                break;
                            }
                        } else {
                            if (!checked[i][j - 1]) {
                                int[] a3 = new int[3];
                                a3[0] = i;
                                a3[1] = j - 1;
                                a3[2] = currentD + 1;
                                q.add(a3);
                                checked[i][j - 1] = true;
                            }
                        }
                    } else {
                        if (!checked[i][j - 1]) {
                            int[] a3 = new int[3];
                            a3[0] = i;
                            a3[1] = j - 1;
                            a3[2] = -1;
                            q.addFirst(a3);
                            checked[i][j - 1] = true;
                        }
                    }
                }
            }
            if (j < n - 1) {
                if (!visited[i][j + 1]) {
                    int indexDown = n * (i) + j + 1;
                    if (!set.contains(indexDown)) {
                        if (A[i][j + 1] == 1) {
                            if (currentD + 1 < min) {
                                min = currentD + 1;
                                break;
                            }
                        } else {
                            if (!checked[i][j + 1]) {
                                int[] a3 = new int[3];
                                a3[0] = i;
                                a3[1] = j + 1;
                                a3[2] = currentD + 1;
                                q.add(a3);
                                checked[i][j + 1] = true;
                            }
                        }
                    } else {
                        if (!checked[i][j + 1]) {
                            int[] a3 = new int[3];
                            a3[0] = i;
                            a3[1] = j + 1;
                            a3[2] = -1;
                            q.addFirst(a3);
                            checked[i][j + 1] = true;
                        }
                    }
                }
            }
        }
        return min;
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
}