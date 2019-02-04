package MS;

public class EightQueens {
    static int n = 8;
    public static void main(String[] args){
        int[][] chessBoard = new int[n][n];
        int r = 0;
        check(r,chessBoard);
    }

    public static boolean check(int row, int[][] twoDArray) {
        if (row == n){
            for(int[] array: twoDArray){
                for(int i: array){
                    System.out.print(i+" ");
                }
                System.out.println();
            }
            System.out.println();
            return true;
        } else {
            for(int j = 0; j < n; j++){
                if(isValid(row, j, twoDArray)){
                    twoDArray[row][j] = 1;
                    if (check(row + 1,twoDArray)) {
                        return true;
                    }
                    twoDArray[row][j] = 0;
                }
            }
            return false;
        }
    }

    public static boolean isValid(int i, int j, int[][] twoDArray){
        for(int k = 0; k < n; k++){
            if(twoDArray[k][j] == 1){
                return false;
            }
        }
        for(int k = 0; k < n; k++){
            if(twoDArray[i][k] == 1){
                return false;
            }
        }
        for(int k = 0; k < n; k++){
            if(twoDArray[i][k] == 1){
                return false;
            }
        }
        int k = 1;
        while (i - k >=0 && j - k >= 0){
            if(twoDArray[i - k][j - k] == 1){
                return false;
            }
            k++;
        }
        k = 1;
        while (i - k >=0 && j + k <= 3){
            if(twoDArray[i - k][j + k] == 1){
                return false;
            }
            k++;
        }
        return true;
    }

}
