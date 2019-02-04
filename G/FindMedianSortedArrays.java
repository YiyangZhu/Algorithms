package G;

public class FindMedianSortedArrays{

    public static double findMedianSortedArraysNaive(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        int a = 0;
        int b = 0;
        int c = 0;
        int[] combinedArray = new int[m + n];
        while(a != m && b != n){
            if(A[a] <= B[b]){
                combinedArray[c] = A[a];
                a++;
            } else {
                combinedArray[c] = B[b];
                b++;
            }
            c++;
        }
        if(a == m){
            while(b != n){
                combinedArray[c] = B[b];
                b++;
                c++;
            }
        }
        if(b == n){
            while(a != m){
                combinedArray[c] = A[a];
                a++;
                c++;
            }
        }
        if(( m + n ) % 2 != 0 ){
            int index = ( m + n ) / 2;
            return combinedArray[index];
        } else {
            int index1 = ( m + n ) / 2;
            int index2 = ( m + n ) / 2 - 1;
            return ((double)combinedArray[index1] + (double)combinedArray[index2]) / 2.0;
        }
    }

}