import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        while(m > 0 && n > 0){
            if(m == 1){
                for(int i = 0; i < n; i++){
                    result.add(matrix[x][y]);
                    x++;
                }
                break;
            } else if(n == 1){
                for(int i = 0; i < m; i++){
                    result.add(matrix[x][y]);
                    y++;
                }
                break;
            }
            //top
            for(int i = 0; i < n-1; i++){
                result.add(matrix[x][y]);
                y++;
            }
            //right
            for(int i = 0; i < m-1; i++){
                result.add(matrix[x][y]);
                x++;
            }
            for(int i = 0; i < n-1; i++){
                result.add(matrix[x][y]);
                x--;
            }
            for(int i = 0; i < m-1;i++){
                result.add(matrix[x][y]);
                y--;
            }
            x++;
            y++;
            m -= 2;
            n -= 2;
        }
        return result;
    }

}
