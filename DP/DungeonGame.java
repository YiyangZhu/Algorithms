package DP;

public class DungeonGame {
    public static void main(String[] args) {
        DungeonGame d = new DungeonGame();
        d.demo();
    }

    private void demo() {
        int[][] a1 = {{2, -3, -5}, {-6, -5, -4}, {-3, -2, -1}};
        System.out.println(calculateMinimumHP(a1));
        int[][] a2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(calculateMinimumHP(a2));
        int[][] a3 = {{2, 1, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(calculateMinimumHP(a3));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1];
        for (int j = n - 2; j >= 0; j--) {
            if (dungeon[m - 1][j] < 0) {
                dp[m - 1][j] = dungeon[m - 1][j];
                if (dp[m - 1][j + 1] < 0) {
                    dp[m - 1][j] += dp[m - 1][j + 1];
                }
            } else {
                dp[m - 1][j] = dungeon[m - 1][j] + dp[m - 1][j + 1];
            }

        }

        for (int i = m - 2; i >= 0; i--) {
            if (dungeon[i][n - 1] < 0) {
                dp[i][n - 1] = dungeon[i][n - 1];
                if (dp[i + 1][n - 1] < 0) {
                    dp[i][n - 1] += dp[i + 1][n - 1];
                }
            } else {
                dp[i][n - 1] = dungeon[i][n - 1] + dp[i + 1][n - 1];
            }

        }

        for (int j = n - 2; j >= 0; j--) {
            for (int i = m - 2; i >= 0; i--) {
                int max = Math.max(dp[i][j + 1], dp[i + 1][j]);
                if (dungeon[i][j] < 0) {
                    dp[i][j] = dungeon[i][j];
                    if (max < 0) {
                        dp[i][j] += max;
                    }
                } else {
                    dp[i][j] = dungeon[i][j] + max;
                }

            }
        }

        if (dp[0][0] > 0) {
            return 1;
        } else {
            return Math.abs(dp[0][0]) + 1;
        }
    }
}
