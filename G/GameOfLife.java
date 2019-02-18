package G;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                count = countPop(temp, i, j);
                board[i][j] = update(board[i][j], count);
            }
        }
    }

    public static int countPop(int[][] temp, int i, int j) {
        int count = 0;
        int m = temp.length;
        int n = temp[0].length;

        //above line
        if (i - 1 >= 0 && j - 1 >= 0 && temp[i - 1][j - 1] == 1) {
            count++;
        }
        if (i - 1 >= 0 && temp[i - 1][j] == 1) {
            count++;
        }
        if (i - 1 >= 0 && j + 1 < n && temp[i - 1][j + 1] == 1) {
            count++;
        }

        //below line
        if (i + 1 < m && j - 1 >= 0 && temp[i + 1][j - 1] == 1) {
            count++;
        }
        if (i + 1 < m && temp[i + 1][j] == 1) {
            count++;
        }
        if (i + 1 < m && j + 1 < n && temp[i + 1][j + 1] == 1) {
            count++;
        }

        //same line
        if (j - 1 >= 0 && temp[i][j - 1] == 1) {
            count++;
        }
        if (j + 1 < n && temp[i][j + 1] == 1) {
            count++;
        }
        return count;
    }

    public static int update(int current, int count) {
        if(count < 2 || count > 3){
            return 0;
        } else if(count == 2){
            return current;
        } else {
            return 1;
        }
    }


    public static void gameOfLifeInPlace(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                count = countPopInPlace(board, i, j);
                board[i][j] = updateInPlace(board[i][j], count);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == -1){
                    board[i][j] = 1;
                } else if(board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }
    }

    public static int countPopInPlace(int[][] temp, int i, int j) {
        int count = 0;
        int m = temp.length;
        int n = temp[0].length;

        //above line
        if (i - 1 >= 0 && j - 1 >= 0 && temp[i - 1][j - 1] > 0) {
            count++;
        }
        if (i - 1 >= 0 && temp[i - 1][j] > 0) {
            count++;
        }
        if (i - 1 >= 0 && j + 1 < n && temp[i - 1][j + 1] > 0) {
            count++;
        }

        //below line
        if (i + 1 < m && j - 1 >= 0 && temp[i + 1][j - 1] > 0) {
            count++;
        }
        if (i + 1 < m && temp[i + 1][j] > 0) {
            count++;
        }
        if (i + 1 < m && j + 1 < n && temp[i + 1][j + 1] > 0) {
            count++;
        }

        //same line
        if (j - 1 >= 0 && temp[i][j - 1] > 0) {
            count++;
        }
        if (j + 1 < n && temp[i][j + 1] > 0) {
            count++;
        }
        return count;
    }

    public static int updateInPlace(int current, int count) {
        int result = 0;
        if(count < 2 || count > 3){
            result =  0;
        } else if(count == 2){
            result = current;
        } else {
            result = 1;
        }

        if(current == 0 && result == 0){
            return 0;
        } else if (current == 0 && result == 1){
            return -1;
        } else if (current == 1 && result == 0){
            return 2;
        } else{
            return 1;
        }
    }


}
