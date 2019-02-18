package G;

public class LongestIncreasingPathInAMatrix {
    static int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1,0}};

    static public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, dp, i, j));
            }
        }
        return res;
    }

    public static int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int mx = 1;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int[] a1 : dirs) {
            int x = i + a1[0];
            int y = j + a1[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + dfs(matrix, dp, x, y);
            mx = Math.max(mx, len);
        }
        dp[i][j] = mx;
        return mx;
    }
}