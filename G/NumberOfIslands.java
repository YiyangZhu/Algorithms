package G;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char ch = grid[i][j];
                if(ch == '1'){
                    merge(grid,i , j);
                    count++;
                }
            }
        }
        return count;

    }

    public static void merge(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n){
            return;
        }
        if(grid[i][j] != '1'){
            return;
        }
        grid[i][j] = 'X';
        merge(grid,i ,j-1 );
        merge(grid, i,j+1 );
        merge(grid,i-1 ,j );
        merge(grid,i+1 ,j );
    }
}
