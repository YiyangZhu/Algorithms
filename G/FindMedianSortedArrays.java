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
            return (double)combinedArray[index];
        } else {
            int index1 = ( m + n ) / 2;
            int index2 = ( m + n ) / 2 - 1;
            return ((double)combinedArray[index1] + (double)combinedArray[index2]) / 2.0;
        }
    }

    public static double findMedianSortedArrays(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        if((m + n) % 2 != 0){
            return (double)findKth(A,B ,(m + n) / 2 , 0,m - 1, 0,n - 1 );
        } else {
            int index1 = (m + n) / 2;
            int index2 = (m + n) / 2 - 1;
            return (findKth(A,B ,index1 ,0 ,m - 1 ,0 ,n-1 )
                    +findKth(A, B, index2, 0,m-1 ,0 ,n-1 )) * 0.5;
        }
    }

    public static int findKth(int[] A, int[] B, int k, int aStart, int aEnd, int bStart,int bEnd){
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        if(aLen == 0){
            return B[bStart + k];
        }
        if(bLen == 0){
            return A[aStart + k];
        }
        if(k == 0){
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
        }

        int aMid = aLen * k / (aLen + bLen);
        int bMid = k - aMid - 1;

        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if(A[aMid] > B[bMid]){
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            aStart = aMid + 1;
            bEnd = bMid;
        }

        return findKth(A,B , k, aStart, aEnd, bStart, bEnd);

    }

}