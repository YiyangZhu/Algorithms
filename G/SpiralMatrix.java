package G;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return null;
        }

        List<Integer> list = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0;
        int y = 0;

        while(m > 0 && n > 0){
            if(m == 1){
                for(int i = 0; i < n; i++){
                    list.add(matrix[x][y]);
                    y++;
                }
                break;
            }

            if(n == 1){
                for(int i = 0; i < m; i++){
                    list.add(matrix[x][y]);
                    x++;
                }
                break;
            }

            //top -- left to right
            for(int i = 0; i < n - 1; i++){
                list.add(matrix[x][y]);
                y++;
            }

            //right -- top to down
            for(int i = 0; i < m - 1; i++){
                list.add(matrix[x][y]);
                x++;
            }

            //down -- right to left
            for(int i = 0; i < n - 1; i++){
                list.add(matrix[x][y]);
                y--;
            }

            //left -- down to top
            for(int i = 0; i < m - 1; i++){
                list.add(matrix[x][y]);
                x--;
            }

            x++;
            y++;
            m -= 2;
            n -= 2;
        }
        return list;

    }
}
