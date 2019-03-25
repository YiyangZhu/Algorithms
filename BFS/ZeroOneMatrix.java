package BFS;

import java.util.LinkedList;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] array = q.poll();
            for (int[] d : dirs) {
                int i1 = array[0] + d[0];
                int j1 = array[1] + d[1];
                if (i1 < 0 || i1 >= m || j1 < 0 || j1 >= n || matrix[i1][j1] <= matrix[array[0]][array[1]] + 1) {
                    continue;
                } else {
                    matrix[i1][j1] = matrix[array[0]][array[1]] + 1;
                    q.offer(new int[]{i1, j1});
                }
            }
        }
        return matrix;
    }
}
