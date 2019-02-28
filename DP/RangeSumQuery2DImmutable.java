package DP;

public class RangeSumQuery2DImmutable {

    int[][] dp;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            dp = new int[0][0];
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m][n];
        dp[0][0] = matrix[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] + matrix[i][j] - dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = dp[row2][col2];
        int upper = 0;
        if (row1 >= 1) {
            upper = dp[row1 - 1][col2];
        }
        int left = 0;
        if (col1 >= 1) {
            left = dp[row2][col1 - 1];
        }
        int overlap = 0;
        if (row1 >= 1 && col1 >= 1) {
            overlap = dp[row1 - 1][col1 - 1];
        }
        return total - upper - left + overlap;
    }
}
