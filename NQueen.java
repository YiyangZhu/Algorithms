import java.util.ArrayList;
import java.util.List;

public class NQueen {



    public static void main(String[] args){
        int n = 4;
        solveNQueens(n);
    }

    public static List<List<String>> solveNQueens(int n) {
        int[] array = new int[n];
        List<List<String>> l = new ArrayList<>();
        search(array, 0,l);
        System.out.println(l);
        return l;
    }

    public static void search(int[] array, int row,List<List<String>> l ){
        if( row == array.length){
            List<String> l1 = new ArrayList<>();
            for(int i = 0; i < array.length;i++){
                String s = "";
                for(int j = 0; j < array.length;j++){
                    if(array[i] == j){
                        s += "Q";
                    } else {
                        s += ".";
                    }
                }
                l1.add(s);
            }
            l.add(l1);
        } else{
            for (int j = 0; j < array.length; j++){
                if(isValid(array, row, j)){
                    array[row] = j;
                    search(array,row + 1,l);
                }
            }
        }
    }

    public static boolean isValid(int[] array, int row, int j){
        for(int i = 0; i < row; i++){
            if (array[i] == j){
                return false;
            }
        }
        int k = 1;
        while ((row - k >=0) && (j - k) >=0){
            if (array[row - k] == j - k){
                return false;
            }
            k++;
        }
        k = 1;
        while ((row - k >=0) && (j + k) < array.length){
            if (array[row - k] == j + k){
                return false;
            }
            k++;
        }
        return true;
    }

    public static void displayM(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0;j < array.length;j++){
                if(array[i] == j){
                    System.out.print("Q");
                } else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
