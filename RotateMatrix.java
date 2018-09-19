public class RotateMatrix {
    public static void main(String[] args){
        int n = 4;
        int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //displayM(m);

        rotate(m);
        displayM(m);

    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2;i++){
            for(int j = i; j < n - 1 - i;j++){ //j = i and j < n - 1 -i very important! set restrictions to j!
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
                System.out.println("i="+i+" j="+j);
                displayM(matrix);
            }
        }
    }

    public static void displayM(int[][] m){
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m.length; j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
